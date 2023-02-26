package com.masemoel.terremotosapi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Terremoto implements Serializable {
    @SerializedName("properties")
    private Propiedades propiedades;
    @SerializedName("geometry")
    private Geometria geometria;
    @SerializedName("id")
    private String id;

    public Terremoto() {

    }

    public Terremoto(Propiedades propiedades, Geometria geometria, String id) {
        this.propiedades = propiedades;
        this.geometria = geometria;
        this.id = id;
    }

    public Propiedades getPropiedades() {
        return propiedades;
    }
    public void setPropiedades(Propiedades propiedades) {
        this.propiedades = propiedades;
    }

    public Geometria getGeometria() {
        return geometria;
    }
    public void setGeometria(Geometria geometria) {
        this.geometria = geometria;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}