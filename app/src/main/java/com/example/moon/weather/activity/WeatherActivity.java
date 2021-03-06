package com.example.moon.weather.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.moon.weather.Bean.WeatherBean;
import com.example.moon.weather.R;
import com.example.moon.weather.model.WeatherJsonResult;
import com.example.moon.weather.service.AutoUpdateService;
import com.example.moon.weather.util.HttpCallbackListener;
import com.example.moon.weather.util.HttpUtil;
import com.example.moon.weather.util.Utility;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class WeatherActivity extends Activity implements View.OnClickListener {

    private LinearLayout weatherInfoLayout;

    private TextView cityNameText;
    /**
     * 用于显示发布时间
     */
    private TextView publishText;
    /**
     * 用于显示天气描述信息
     */
    private TextView weatherDespText;
    /**
     * 用于显示气温1
     */
    private TextView temp1Text;
    /**
     * 用于显示气温2
     */
    private TextView temp2Text;
    /**
     * 用于显示当前日期
     */
    private TextView currentDateText;
    /**
     * 切换城市按钮
     */
    private Button switchCity;
    /**
     * 更新天气按钮
     */
    private Button refreshWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.weather_layout);
        weatherInfoLayout = (LinearLayout) findViewById(R.id.weather_info_layout);
        cityNameText = (TextView) findViewById(R.id.city_name);
        publishText = (TextView) findViewById(R.id.public_text);
        weatherDespText = (TextView) findViewById(R.id.weather_desp);
        temp1Text = (TextView) findViewById(R.id.temp1);
        temp2Text = (TextView) findViewById(R.id.temp2);
        currentDateText = (TextView) findViewById(R.id.current_date);
        switchCity = (Button) findViewById(R.id.switch_city);
        refreshWeather = (Button) findViewById(R.id.refresh_weather);
        switchCity.setOnClickListener(this);
        refreshWeather.setOnClickListener(this);
        String countyCode = getIntent().getStringExtra("county_code");
        if(!TextUtils.isEmpty(countyCode)) {
            publishText.setText("同步中");
            weatherInfoLayout.setVisibility(View.INVISIBLE);
            cityNameText.setVisibility(View.INVISIBLE);
            queryWeather(countyCode);
        } else {
            showWeather();
        }
    }

    private void queryWeather(String countyCode) {
        String address = "https://api.heweather.com/x3/weather?cityid="+countyCode+"&key=a2f3cf596694476ab96a29fd66a95ddc";
        HttpUtil.sendHttpGetRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                response=response.substring(31,response.length()-2);
                //Log.d("测试",response);

//                try {
                    Gson gson = new Gson();
                    WeatherBean weatherBean = gson.fromJson(response,WeatherBean.class);
                    Log.d("json测试",weatherBean.getStatus());
//                } catch (JsonSyntaxException e) {
//                Log.d("json解析错误",e.toString());
//                e.printStackTrace();
//
//            }
                Utility.SaveWeather(WeatherActivity.this,weatherBean);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showWeather();
                    }
                });
            }

            @Override
            public void onError(Exception e) {
                Log.d("测试错误",e.toString());
            }
        });
    }



    public void showWeather() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        cityNameText.setText(preferences.getString("city_name",""));
        temp1Text.setText(preferences.getInt("temp1", 0)+"℃");
        temp2Text.setText(preferences.getInt("temp2", 0)+"℃");
        weatherDespText.setText(preferences.getString("weather_desp", ""));
        publishText.setText(preferences.getString("public_time","")+"发布");
        currentDateText.setText(preferences.getString("current_date", ""));
        cityNameText.setVisibility(View.VISIBLE);
        weatherInfoLayout.setVisibility(View.VISIBLE);
        Intent intent = new Intent(this, AutoUpdateService.class);
        startService(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.switch_city: {
                Intent intent = new Intent(WeatherActivity.this,ChooseAreaActivity.class);
                intent.putExtra("is_from_Weather_Activity",true);
                startActivity(intent);
                finish();

                break;
            }
            case R.id.refresh_weather: {
                publishText.setText("同步中");
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                String city_code = sharedPreferences.getString("city_code", "");
                if(!TextUtils.isEmpty(city_code)) {
                    queryWeather(city_code);
                    Log.d("刷新", "刷新成功");
                } else {
                    Log.d("刷新","刷新失败");
                }
                break;
            }
        }

    }
}
