package com.example.moon.weather.model;

import java.util.List;

/**
 * Created by Moon on 2016/3/30.
 */
public class WeatherJsonResult {

//    private Basic basic;
//    private List<Daily_forecast> daily_forecast;
//    private List<Hourly_forecast> hourly_forecast;
//    private Now now;
//    private String status;
//    private Suggestion suggestion;


//    public static class Now {
//        private NowCond cond;
//        private NowFl fl;
//
//        public NowCond getCond() {
//            return cond;
//        }
//
//        public void setCond(NowCond cond) {
//            this.cond = cond;
//        }
//
//        public NowFl getFl() {
//            return fl;
//        }
//
//        public void setFl(NowFl fl) {
//            this.fl = fl;
//        }
//
//        public static class NowFl {
//            private String fl;
//            private String hum;
//            private String pcpn;
//            private String pres;
//            private String tmp;
//            private String vis;
//            private NowWind wind;
//
//            public String getFl() {
//                return fl;
//            }
//
//            public void setFl(String fl) {
//                this.fl = fl;
//            }
//
//            public String getHum() {
//                return hum;
//            }
//
//            public void setHum(String hum) {
//                this.hum = hum;
//            }
//
//            public String getPcpn() {
//                return pcpn;
//            }
//
//            public void setPcpn(String pcpn) {
//                this.pcpn = pcpn;
//            }
//
//            public String getPres() {
//                return pres;
//            }
//
//            public void setPres(String pres) {
//                this.pres = pres;
//            }
//
//            public String getTmp() {
//                return tmp;
//            }
//
//            public void setTmp(String tmp) {
//                this.tmp = tmp;
//            }
//
//            public String getVis() {
//                return vis;
//            }
//
//            public void setVis(String vis) {
//                this.vis = vis;
//            }
//
//            public NowWind getWind() {
//                return wind;
//            }
//
//            public void setWind(NowWind wind) {
//                this.wind = wind;
//            }
//
//            public static class NowWind {
//                private String deg;
//                private String dir;
//                private String sc;
//                private String spd;
//
//                public String getDeg() {
//                    return deg;
//                }
//
//                public void setDeg(String deg) {
//                    this.deg = deg;
//                }
//
//                public String getDir() {
//                    return dir;
//                }
//
//                public void setDir(String dir) {
//                    this.dir = dir;
//                }
//
//                public String getSc() {
//                    return sc;
//                }
//
//                public void setSc(String sc) {
//                    this.sc = sc;
//                }
//
//                public String getSpd() {
//                    return spd;
//                }
//
//                public void setSpd(String spd) {
//                    this.spd = spd;
//                }
//            }
//        }
//        public static  class  NowCond {
//            private String code;
//            private String txt;
//
//            public String getCode() {
//                return code;
//            }
//
//            public void setCode(String code) {
//                this.code = code;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
//        }
//    }
//    public static class Suggestion {
//        private Comf comf;
//        private Cw cw;
//        private Drsg drsg;
//        private Flu flu;
//        private Sport sport;
//        private Trav trav;
//        private Uv uv;
//
//        public Comf getComf() {
//            return comf;
//        }
//
//        public void setComf(Comf comf) {
//            this.comf = comf;
//        }
//
//        public Cw getCw() {
//            return cw;
//        }
//
//        public void setCw(Cw cw) {
//            this.cw = cw;
//        }
//
//        public Drsg getDrsg() {
//            return drsg;
//        }
//
//        public void setDrsg(Drsg drsg) {
//            this.drsg = drsg;
//        }
//
//        public Flu getFlu() {
//            return flu;
//        }
//
//        public void setFlu(Flu flu) {
//            this.flu = flu;
//        }
//
//        public Sport getSport() {
//            return sport;
//        }
//
//        public void setSport(Sport sport) {
//            this.sport = sport;
//        }
//
//        public Trav getTrav() {
//            return trav;
//        }
//
//        public void setTrav(Trav trav) {
//            this.trav = trav;
//        }
//
//        public Uv getUv() {
//            return uv;
//        }
//
//        public void setUv(Uv uv) {
//            this.uv = uv;
//        }
//
//        public static class Uv {
//            private String brf;
//            private String txt;
//
//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
//        }
//        public static class Trav {
//            private String brf;
//            private String txt;
//
//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
//        }
//        public static class Sport {
//            private String brf;
//            private String txt;
//
//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
//        }
//        public static class Flu {
//            private String brf;
//            private String txt;
//
//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
//        }
//        public static class Drsg {
//            private String brf;
//            private String txt;
//
//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
//        }
//        public static class Cw {
//            private String brf;
//            private String txt;
//
//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
//        }
//        public static class Comf {
//            private String brf;
//            private String txt;
//
//            public String getBrf() {
//                return brf;
//            }
//
//            public void setBrf(String brf) {
//                this.brf = brf;
//            }
//
//            public String getTxt() {
//                return txt;
//            }
//
//            public void setTxt(String txt) {
//                this.txt = txt;
//            }
//        }
//    }
//    public static class Hourly_forecast {
//        private String date;
//        private String hum;
//        private String pop;
//        private String pres;
//        private String tmp;
//        private DataWind wind;
//
//        public String getDate() {
//            return date;
//        }
//
//        public void setDate(String date) {
//            this.date = date;
//        }
//
//        public String getHum() {
//            return hum;
//        }
//
//        public void setHum(String hum) {
//            this.hum = hum;
//        }
//
//        public String getPop() {
//            return pop;
//        }
//
//        public void setPop(String pop) {
//            this.pop = pop;
//        }
//
//        public String getPres() {
//            return pres;
//        }
//
//        public void setPres(String pres) {
//            this.pres = pres;
//        }
//
//        public String getTmp() {
//            return tmp;
//        }
//
//        public void setTmp(String tmp) {
//            this.tmp = tmp;
//        }
//
//        public DataWind getWind() {
//            return wind;
//        }
//
//        public void setWind(DataWind wind) {
//            this.wind = wind;
//        }
//
//        public static class DataWind {
//            private String deg;
//            private String dir;
//            private String sc;
//            private String spd;
//
//            public String getDeg() {
//                return deg;
//            }
//
//            public void setDeg(String deg) {
//                this.deg = deg;
//            }
//
//            public String getDir() {
//                return dir;
//            }
//
//            public void setDir(String dir) {
//                this.dir = dir;
//            }
//
//            public String getSc() {
//                return sc;
//            }
//
//            public void setSc(String sc) {
//                this.sc = sc;
//            }
//
//            public String getSpd() {
//                return spd;
//            }
//
//            public void setSpd(String spd) {
//                this.spd = spd;
//            }
//        }
//
//    }
//    public static class Daily_forecast {
//        private Astro astro;
//        private Cond cond;
//        private String date;
//        private String hum;
//        private String pcpn;
//        private String pop;
//        private String pres;
//        private Tmp tmp;
//        private String vis;
//        private Wind wind;
//
//        public String getDate() {
//            return date;
//        }
//
//        public void setDate(String date) {
//            this.date = date;
//        }
//
//        public String getHum() {
//            return hum;
//        }
//
//        public void setHum(String hum) {
//            this.hum = hum;
//        }
//
//        public String getPcpn() {
//            return pcpn;
//        }
//
//        public void setPcpn(String pcpn) {
//            this.pcpn = pcpn;
//        }
//
//        public String getPop() {
//            return pop;
//        }
//
//        public void setPop(String pop) {
//            this.pop = pop;
//        }
//
//        public String getPres() {
//            return pres;
//        }
//
//        public void setPres(String pres) {
//            this.pres = pres;
//        }
//
//        public Tmp getTmp() {
//            return tmp;
//        }
//
//        public void setTmp(Tmp tmp) {
//            this.tmp = tmp;
//        }
//
//        public String getVis() {
//            return vis;
//        }
//
//        public void setVis(String vis) {
//            this.vis = vis;
//        }
//
//        public Wind getWind() {
//            return wind;
//        }
//
//        public void setWind(Wind wind) {
//            this.wind = wind;
//        }
//
//        public Astro getAstro() {
//            return astro;
//        }
//
//        public void setAstro(Astro astro) {
//            this.astro = astro;
//        }
//
//        public Cond getCond() {
//            return cond;
//        }
//
//        public void setCond(Cond cond) {
//            this.cond = cond;
//        }
//
//        public static class Wind {
//            private String deg;
//            private String dir;
//            private String sc;
//            private String spd;
//
//            public String getDeg() {
//                return deg;
//            }
//
//            public void setDeg(String deg) {
//                this.deg = deg;
//            }
//
//            public String getDir() {
//                return dir;
//            }
//
//            public void setDir(String dir) {
//                this.dir = dir;
//            }
//
//            public String getSc() {
//                return sc;
//            }
//
//            public void setSc(String sc) {
//                this.sc = sc;
//            }
//
//            public String getSpd() {
//                return spd;
//            }
//
//            public void setSpd(String spd) {
//                this.spd = spd;
//            }
//        }
//
//        public static class Tmp {
//            private String max;
//            private String min;
//
//            public String getMax() {
//                return max;
//            }
//
//            public void setMax(String max) {
//                this.max = max;
//            }
//
//            public String getMin() {
//                return min;
//            }
//
//            public void setMin(String min) {
//                this.min = min;
//            }
//        }
//
//
//        public static class Cond {
//            private String code_d;
//            private String code_n;
//            private String txt_d;
//            private String txt_n;
//
//
//            public String getCode_d() {
//                return code_d;
//            }
//
//            public void setCode_d(String code_d) {
//                this.code_d = code_d;
//            }
//
//            public String getCode_n() {
//                return code_n;
//            }
//
//            public void setCode_n(String code_n) {
//                this.code_n = code_n;
//            }
//
//            public String getTxt_d() {
//                return txt_d;
//            }
//
//            public void setTxt_d(String txt_d) {
//                this.txt_d = txt_d;
//            }
//
//            public String getTxt_n() {
//                return txt_n;
//            }
//
//            public void setTxt_n(String txt_n) {
//                this.txt_n = txt_n;
//            }
//
//
//
//
//
//
//        }
//
//        public static class  Astro {
//            private String sr;
//            private String ss;
//
//            public String getSr() {
//                return sr;
//            }
//
//            public void setSr(String sr) {
//                this.sr = sr;
//            }
//
//            public String getSs() {
//                return ss;
//            }
//
//            public void setSs(String ss) {
//                this.ss = ss;
//            }
//        }
//    }
//    public static class Basic {
//        private String city;
//        private String cnty;
//        private String id;
//        private String lat;
//        private String lon;
//        private Update update;
//
//        public String getCity() {
//            return city;
//        }
//
//        public void setCity(String city) {
//            this.city = city;
//        }
//
//        public String getCnty() {
//            return cnty;
//        }
//
//        public void setCnty(String cnty) {
//            this.cnty = cnty;
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getLat() {
//            return lat;
//        }
//
//        public void setLat(String lat) {
//            this.lat = lat;
//        }
//
//        public String getLon() {
//            return lon;
//        }
//
//        public void setLon(String lon) {
//            this.lon = lon;
//        }
//
//        public Update getUpdate() {
//            return update;
//        }
//
//        public void setUpdate(Update update) {
//            this.update = update;
//        }
//
//        public static class Update {
//            private String loc;
//            private String utc;
//
//            public String getLoc() {
//                return loc;
//            }
//
//            public void setLoc(String loc) {
//                this.loc = loc;
//            }
//
//            public String getUtc() {
//                return utc;
//            }
//
//            public void setUtc(String utc) {
//                this.utc = utc;
//            }
//        }
//
//    }
}
