package com.example.moon.weather.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.example.moon.weather.Bean.WeatherBean;
import com.example.moon.weather.activity.WeatherActivity;
import com.example.moon.weather.util.HttpCallbackListener;
import com.example.moon.weather.util.HttpUtil;
import com.example.moon.weather.util.Utility;
import com.google.gson.Gson;

/**
 * Created by Moon on 2016/4/2.
 */
public class AutoUpdateService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                UpdateWeather();
            }
        }).start();
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int anHour = 2*60*60*1000;
        long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
        Intent i = new Intent(this,AutoUpdateService.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,i,0);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pendingIntent);

        return super.onStartCommand(intent, flags, startId);
    }

    private void UpdateWeather() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String countyCode = sharedPreferences.getString("city_code","");
        if (!TextUtils.isEmpty(countyCode)) {
            String address = "https://api.heweather.com/x3/weather?cityid="+countyCode+"&key=a2f3cf596694476ab96a29fd66a95ddc";
            HttpUtil.sendHttpGetRequest(address, new HttpCallbackListener() {
                @Override
                public void onFinish(String response) {
                    response=response.substring(31,response.length()-2);
                    Gson gson = new Gson();
                    WeatherBean weatherBean = gson.fromJson(response,WeatherBean.class);
                    Utility.SaveWeather(AutoUpdateService.this,weatherBean);
                }

                @Override
                public void onError(Exception e) {

                }
            });
        }
    }
}
