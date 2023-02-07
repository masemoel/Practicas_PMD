package com.masemoel.retrofitusuarios.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("data")
    private List<Usuario> data;

    public List<Usuario> getData() {
        return data;
    }
    public void setData(List<Usuario> data) {
        this.data = data;
    }
}