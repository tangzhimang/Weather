package com.example.moon.weather.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.moon.weather.R;

/**
 * Created by Administrator on 2016/3/28.
 */
public class ChooseAreaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.choose_area);
    }
}
