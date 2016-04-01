package com.example.moon.weather.Bean;

/**
 * Created by Administrator on 2016/4/1.
 */
public class Suggestion {
    private SuggestionMessage comf;
    private SuggestionMessage cw;
    private SuggestionMessage drsg;
    private SuggestionMessage flu;
    private SuggestionMessage sport;
    private SuggestionMessage trav;
    private SuggestionMessage uv;

    public SuggestionMessage getComf() {
        return comf;
    }

    public void setComf(SuggestionMessage comf) {
        this.comf = comf;
    }

    public SuggestionMessage getCw() {
        return cw;
    }

    public void setCw(SuggestionMessage cw) {
        this.cw = cw;
    }

    public SuggestionMessage getDrsg() {
        return drsg;
    }

    public void setDrsg(SuggestionMessage drsg) {
        this.drsg = drsg;
    }

    public SuggestionMessage getFlu() {
        return flu;
    }

    public void setFlu(SuggestionMessage flu) {
        this.flu = flu;
    }

    public SuggestionMessage getSport() {
        return sport;
    }

    public void setSport(SuggestionMessage sport) {
        this.sport = sport;
    }

    public SuggestionMessage getTrav() {
        return trav;
    }

    public void setTrav(SuggestionMessage trav) {
        this.trav = trav;
    }

    public SuggestionMessage getUv() {
        return uv;
    }

    public void setUv(SuggestionMessage uv) {
        this.uv = uv;
    }

    public static class SuggestionMessage {
        private String brf;
        private String txt;

        public String getBrf() {
            return brf;
        }

        public void setBrf(String brf) {
            this.brf = brf;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }
    }
}
