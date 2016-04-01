package com.example.moon.weather.Bean;

/**
 * Created by Administrator on 2016/4/1.
 */
public class Now {
    private NestCond cond;
    private int fl;
    private int hum;
    private int pcpn;
    private int pres;
    private int tmp;
    private int vis;
    private NestWind wind;

    public NestCond getCond() {
        return cond;
    }

    public void setCond(NestCond cond) {
        this.cond = cond;
    }

    public int getFl() {
        return fl;
    }

    public void setFl(int fl) {
        this.fl = fl;
    }

    public int getHum() {
        return hum;
    }

    public void setHum(int hum) {
        this.hum = hum;
    }

    public int getPcpn() {
        return pcpn;
    }

    public void setPcpn(int pcpn) {
        this.pcpn = pcpn;
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

    public int getVis() {
        return vis;
    }

    public void setVis(int vis) {
        this.vis = vis;
    }

    public NestWind getWind() {
        return wind;
    }

    public void setWind(NestWind wind) {
        this.wind = wind;
    }
}
