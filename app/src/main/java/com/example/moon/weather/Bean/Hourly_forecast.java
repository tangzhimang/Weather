package com.example.moon.weather.Bean;

/**
 * Created by Administrator on 2016/4/1.
 */
public class Hourly_forecast {
    private String date;
    private int hum;
    private int pop;
    private int pres;
    private int tmp;
    private NestWind wind;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHum() {
        return hum;
    }

    public void setHum(int hum) {
        this.hum = hum;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public int getPres() {
        return pres;
    }

    public void setPres(int pres) {
        this.pres = pres;
    }

    public int getTmp() {
        return tmp;
    }

    public void setTmp(int tmp) {
        this.tmp = tmp;
    }

    public NestWind getWind() {
        return wind;
    }

    public void setWind(NestWind wind) {
        this.wind = wind;
    }
}
