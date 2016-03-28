package com.example.moon.weather.util;

/**
 * Created by Administrator on 2016/3/28.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
