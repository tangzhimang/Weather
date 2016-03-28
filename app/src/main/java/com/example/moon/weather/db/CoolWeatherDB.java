package com.example.moon.weather.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.moon.weather.model.City;
import com.example.moon.weather.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/28.
 */
public class CoolWeatherDB {

    public static final String DB_NAME = "cool_weather";
    public static final int VERSION = 1;

    private static CoolWeatherDB coolWeatherDB;
    private SQLiteDatabase db;

    private CoolWeatherDB(Context context) {
        CoolWeatherOpenHelper dbhelper = new CoolWeatherOpenHelper(context,DB_NAME,null,VERSION);
        db = dbhelper.getWritableDatabase();
    }

    public synchronized static CoolWeatherDB getInstance(Context context) {
        if(coolWeatherDB == null) {
            coolWeatherDB = new CoolWeatherDB(context);
        }

        return coolWeatherDB;
    }

    public void saveProvince(Province province) {
        if(province != null) {
            db.execSQL("insert into Province(province_name,province_code) values (?,?)",new String[]{province.getProvinceName(),province.getProviceCode()});
        }
    }

    public List<Province> loadProvinces() {
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.rawQuery("select * from Province",null);
        if(cursor.moveToFirst()) {
            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProviceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);


            } while(cursor.moveToNext());
        }
        return list;
    }

    public void saveCity(City city) {
        if(city != null) {
            db.execSQL("insert into P");
        }
    }


















}
