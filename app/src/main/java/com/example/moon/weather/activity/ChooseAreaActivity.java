package com.example.moon.weather.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moon.weather.R;
import com.example.moon.weather.db.CoolWeatherDB;
import com.example.moon.weather.model.City;
import com.example.moon.weather.model.County;
import com.example.moon.weather.model.JsonResult;
import com.example.moon.weather.model.Province;
import com.example.moon.weather.util.HttpCallbackListener;
import com.example.moon.weather.util.HttpUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/28.
 */
public class ChooseAreaActivity extends Activity {

    public static final int LEVEL_PROVINCE = 0;
    public static final int LEVEL_CITY = 1;
    public static final int LEVEL_COUNTY = 2;

    private static final String WEB_ADDRESS = "https://api.heweather.com/x3/citylist?search=allchina&key=a2f3cf596694476ab96a29fd66a95ddc";

    private ProgressDialog progressDialog;
    private ListView listView;
    private TextView textView;
    private ArrayAdapter<String> adapter;
    private CoolWeatherDB coolWeatherDB;
    private List<String>  dataList = new ArrayList<String>();

    private List<Province> provinceList;

    private List<City> cityList;

    private List<County> countyList;

    private Province selectProvince;

    private City selectCity;

    private int currentLEVEL;

    private boolean isfromWeatherActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isfromWeatherActivity = getIntent().getBooleanExtra("is_from_Weather_Activity",false);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(sharedPreferences.getBoolean("city_selected",false)&&!isfromWeatherActivity) {
            Intent intent = new Intent(this,WeatherActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.choose_area);
        listView = (ListView) findViewById(R.id.list_view);
        textView = (TextView) findViewById(R.id.title_text);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,dataList);
        listView.setAdapter(adapter);
        coolWeatherDB = CoolWeatherDB.getInstance(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(currentLEVEL == LEVEL_PROVINCE) {
                    selectProvince = provinceList.get(position);
                    queryCity();
                } else if(currentLEVEL == LEVEL_CITY) {
                    selectCity = cityList.get(position);
                    Intent intent = new Intent(ChooseAreaActivity.this,WeatherActivity.class);
                    intent.putExtra("county_code",selectCity.getCityCode());
                    startActivity(intent);
                    finish();
                }

            }
        });
        queryProvinces();
    }

    @Override
    public void onBackPressed() {
        if(currentLEVEL == LEVEL_CITY) {
            queryProvinces();
        } else {
            if(isfromWeatherActivity) {
                Intent intent = new Intent(this,WeatherActivity.class);
                startActivity(intent);
            }
            finish();
        }

    }

    private void queryCity() {
        cityList = coolWeatherDB.loadCitys(selectProvince.getId());
        if(cityList.size()>0) {
            dataList.clear();
            for(City city:cityList) {
                dataList.add(city.getCityName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            textView.setText(selectProvince.getProvinceName());
            currentLEVEL = LEVEL_CITY;
        } else {
            currentLEVEL = LEVEL_CITY;
            queryFromServer(selectProvince.getProvinceName());
        }


    }

    private void queryProvinces() {
        provinceList = coolWeatherDB.loadProvinces();
        if(provinceList.size()>0) {
            dataList.clear();
            for(Province province:provinceList) {
                dataList.add(province.getProvinceName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            textView.setText("中国");
            currentLEVEL = LEVEL_PROVINCE;

        } else {
            queryFromServer("province");
        }
    }

    private void queryFromServer( final String province) {
        showProgressDialog();
        HttpUtil.sendHttpGetRequest(WEB_ADDRESS, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                //Log.d("读取测试",response);
                Gson gson = new Gson();
                JsonResult jsonResult = gson.fromJson(response, JsonResult.class);
                if(province.equals("province")) {
                    insertSQLiteProvince(jsonResult);
                } else {
                    insertSQLiteCity(jsonResult);
                }
//                Log.d("读取测试", jsonResult.getStatus());
//
//                List<JsonResult.City_Info> city_infoList = jsonResult.getCity_info();
//                int i =0;
//                for(JsonResult.City_Info city_info:city_infoList) {
//                    Log.d("读取测试",city_info.getCity()+"       "+city_info.getProv());
//                    i++;
//                }
//                Log.d("读取测试",i+"个城市");

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialog();
                        Toast.makeText(ChooseAreaActivity.this,
                                "加载完成", Toast.LENGTH_SHORT).show();
                        if(currentLEVEL == LEVEL_PROVINCE) {
                            queryProvinces();
                        } else {
                            queryCity();
                        }

                    }
                });

            }

            @Override
            public void onError(Exception e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialog();
                        Toast.makeText(ChooseAreaActivity.this,
                                "加载失败", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    private void insertSQLiteCity(JsonResult jsonResult) {

        List<JsonResult.City_Info> city_infoList = jsonResult.getCity_info();
        int i=0;
        String currentProvince = " ";
        for(JsonResult.City_Info city_info:city_infoList) {
            if(!city_info.getProv().equals(currentProvince)) {
                currentProvince = city_info.getProv();


                i++;
            }
            if(city_info.getProv().equals(selectProvince.getProvinceName())) {
                 City city = new City();
                 city.setCityName(city_info.getCity());
                 city.setCityCode(city_info.getId());
                 city.setProvinceId(i);
                 coolWeatherDB.saveCity(city);
                //Log.d("读取测试",city_info.getCity()+"       "+city_info.getProv());
            }
        }
    }

    private void insertSQLiteProvince(JsonResult jsonResult) {

        List<JsonResult.City_Info> city_infoList = jsonResult.getCity_info();
        int i=0;
        String currentProvince = " ";
        for(JsonResult.City_Info city_info:city_infoList) {
            if(!city_info.getProv().equals(currentProvince)) {
                currentProvince = city_info.getProv();

                Province province = new Province();
                province.setProvinceName(city_info.getProv());
                province.setProviceCode(i+"");
                coolWeatherDB.saveProvince(province);
                i++;
            }
//            City city = new City();
//            city.setCityName(city_info.getCity());
//            city.setCityCode(city_info.getId());
//            city.setProvinceId(i);
//            coolWeatherDB.saveCity(city);
            //Log.d("读取测试",city_info.getCity()+"       "+city_info.getProv());

        }
    }

    private void showProgressDialog() {
        if(progressDialog==null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("正在加载......");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    private void closeProgressDialog() {
        if(progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
