package com.example.moon.weather.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.moon.weather.Bean.Daily_forecast;
import com.example.moon.weather.Bean.WeatherBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2016/4/1.
 */
public class Utility {

    public static void SaveWeather(Context context,WeatherBean weatherBean) {
        List<Daily_forecast> daily_forecastList = weatherBean.getDaily_forecast();
        Daily_forecast daily_forecast1 = daily_forecastList.get(0);
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年M月d日", Locale.CHINA);
        editor.putBoolean("city_selected", true);
        editor.putString("current_date", simpleDateFormat.format(new Date()));
        editor.putString("city_name", weatherBean.getBasic().getCity());
        if(!daily_forecast1.getCond().getCode_d().equals(daily_forecast1.getCond().getCode_n())) {
            editor.putString("weather_desp", daily_forecast1.getCond().getTxt_d() + "到" + daily_forecast1.getCond().getTxt_n());
        }else {
            editor.putString("weather_desp",daily_forecast1.getCond().getTxt_d());
        }
        editor.putInt("temp1",daily_forecast1.getTmp().getMin());
        editor.putInt("temp2", daily_forecast1.getTmp().getMax());
        editor.putString("city_code", weatherBean.getBasic().getId());
        editor.putString("public_time",weatherBean.getBasic().getUpdate().getLoc());

        editor.commit();

    }


}
