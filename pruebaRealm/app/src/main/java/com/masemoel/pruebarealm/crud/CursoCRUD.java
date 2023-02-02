package com.masemoel.pruebarealm.crud;

import com.masemoel.pruebarealm.modelo.Curso;
import com.masemoel.pruebarealm.modelo.Profesor;

import io.realm.Realm;

public class CursoCRUD {
    public static void addCurso(String idProfesor, Curso curso) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        int id = Integer.parseInt(idProfesor);
        Profesor profesor = ProfesorCRUD.getProfesorByID(id);
        profesor.getCursos().add(curso);
        realm.insertOrUpdate(profesor);
        realm.commitTransaction();
    }

    public static void updateByNombre(String nombre) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Curso curso = realm.where(Curso.class).equalTo("nombre", nombre).findFirst();
        if (curso != null) {
            curso.setNombre("Curso MOD");
            curso.setDuracion("Duracion Modificada");
            realm.insertOrUpdate(curso);
        }
        realm.commitTransaction();
    }

}
