package com.masemoel.terremotosapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Geometria {
    @SerializedName("coordinates")
    private List<Float> coordenadas;

    public Geometria() {

    }

    public Geometria(List<Float> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public List<Float> getCoordenadas() {
        return coordenadas;
    }
    public void setCoordenadas(List<Float> coordenadas) {
        this.coordenadas = coordenadas;
    }
}