package com.masemoel.terremotosapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("features")
    private List<Terremoto> features;

    public List<Terremoto> getFeatures() {
        return features;
    }
    public void setFeatures(List<Terremoto> features) {
        this.features = features;
    }
}