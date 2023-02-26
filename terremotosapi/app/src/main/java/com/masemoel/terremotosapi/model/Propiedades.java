package com.masemoel.terremotosapi.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class Propiedades {
    @SerializedName("time")
    private long time;
    @SerializedName("tsunami")
    private int tsunami;
    @SerializedName("title")
    private String title;

    public Propiedades() {

    }

    public Propiedades(long time, int tsunami, String title) {
        this.time = time;
        this.tsunami = tsunami;
        this.title = title;
    }

    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }

    public int getTsunami() {
        return tsunami;
    }
    public void setTsunami(int tsunami) {
        this.tsunami = tsunami;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}