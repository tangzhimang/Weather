package com.example.moon.weather.Bean;

/**
 * Created by Administrator on 2016/4/1.
 */
public class Daily_forecast {
    private String date;
    private Astro astro;
    private NestCond cond;
    private int hum;
    private double pcpn;
    private int pop;
    private int pres;
    private Tmp tmp;
    private int vis;
    private NestWind wind;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Astro getAstro() {
        return astro;
    }

    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    public NestCond getCond() {
        return cond;
    }

    public void setCond(NestCond cond) {
        this.cond = cond;
    }

    public int getHum() {
        return hum;
    }

    public void setHum(int hum) {
        this.hum = hum;
    }

    public double getPcpn() {
        return pcpn;
    }

    public void setPcpn(double pcpn) {
        this.pcpn = pcpn;
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

    public Tmp getTmp() {
        return tmp;
    }

    public void setTmp(Tmp tmp) {
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

    public static  class  Tmp {
        private int max;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }
    public static class Astro {
        private String sr;
        private String ss;

        public String getSr() {
            return sr;
        }

        public void setSr(String sr) {
            this.sr = sr;
        }

        public String getSs() {
            return ss;
        }

        public void setSs(String ss) {
            this.ss = ss;
        }
    }
}
