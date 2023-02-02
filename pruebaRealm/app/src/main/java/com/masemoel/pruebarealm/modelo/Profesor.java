package com.masemoel.pruebarealm.modelo;

import com.masemoel.pruebarealm.modelo.Curso;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Profesor extends RealmObject {

    @PrimaryKey
    private int id;
    private String nombre;
    private String email;

    private RealmList<Curso> cursos;

    public Profesor(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Profesor() {

    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", cursos=" + cursos +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RealmList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(RealmList<Curso> cursos) {
        this.cursos = cursos;
    }
}
