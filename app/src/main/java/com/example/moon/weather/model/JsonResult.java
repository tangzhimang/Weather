package com.example.moon.weather.model;

import java.util.List;

/**
 * Created by Administrator on 2016/3/29.
 */
public class JsonResult  {

    private List<City_Info> city_info;

    private String status;

    public List<City_Info> getCity_info() {
        return city_info;
    }

    public void setCity_info(List<City_Info> city_info) {
        this.city_info = city_info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class City_Info {

        private String city;
        private String cnty;
        private String id;
        private String lat;
        private String lon;
        private String prov;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCnty() {
            return cnty;
        }

        public void setCnty(String cnty) {
            this.cnty = cnty;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getProv() {
            return prov;
        }

        public void setProv(String prov) {
            this.prov = prov;
        }
    }

}
