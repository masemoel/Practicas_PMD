package com.masemoel.pruebarealm.modelo;

import io.realm.RealmObject;

public class Curso extends RealmObject {

    private String nombre;
    private String duracion;

    public Curso(String nombre, String duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public Curso() {

    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", duracion='" + duracion + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
