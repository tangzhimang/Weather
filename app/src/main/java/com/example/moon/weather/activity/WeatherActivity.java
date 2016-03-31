package com.example.moon.weather.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.moon.weather.R;
import com.example.moon.weather.model.WeatherJsonResult;
import com.example.moon.weather.util.HttpCallbackListener;
import com.example.moon.weather.util.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class WeatherActivity extends Activity implements DialogInterface.OnClickListener {

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
        String countyCode = getIntent().getStringExtra("county_code");
        if(!TextUtils.isEmpty(countyCode)) {
            publishText.setText("同步中");
            weatherInfoLayout.setVisibility(View.INVISIBLE);
            cityNameText.setVisibility(View.INVISIBLE);
            queryWeather(countyCode);
        }
    }

    private void queryWeather(String countyCode) {
        String address = "https://api.heweather.com/x3/weather?cityid="+countyCode+"&key=a2f3cf596694476ab96a29fd66a95ddc";
        HttpUtil.sendHttpGetRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                response=response.substring(31,response.length()-2);
                //Log.d("测试",response);

                try {
                    Gson gson = new Gson();
                    WeatherJsonResult weatherJsonResult = gson.fromJson(response,WeatherJsonResult.class);
                    Log.d("json测试",weatherJsonResult.getStatus());
                } catch (JsonSyntaxException e) {
                    Log.d("json解析错误",e.toString());
                    e.printStackTrace();

                }
            }

            @Override
            public void onError(Exception e) {
                Log.d("测试错误",e.toString());
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
