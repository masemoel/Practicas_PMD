package com.masemoel.pruebarealm.crud;

import android.util.Log;

import com.masemoel.pruebarealm.modelo.Profesor;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ProfesorCRUD {
    private static int calculaSiguienteID() {
        Realm realm = Realm.getDefaultInstance();
        Number idActual = realm.where(Profesor.class).max("id");
        return (idActual == null) ? 0 : idActual.intValue() + 1;
    }

    public static void addProfesor(final Profesor profesor) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(r -> {
            int indice = calculaSiguienteID();
            Profesor realmProfesor = r.createObject(Profesor.class, indice);
            realmProfesor.setNombre(profesor.getNombre());
            realmProfesor.setEmail(profesor.getEmail());
        });
        realm.close();
    }

    public static List<Profesor> getAllProfesores() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Profesor.class).findAll();
    }

    public static Profesor getProfesorByName(String nombre) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Profesor.class)
                .equalTo("nombre", nombre)
                .findFirst();
    }

    public static Profesor getProfesorByID(int id) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Profesor.class)
                .equalTo("id", id)
                .findFirst();
    }

    public static void updateByID(int id) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Profesor profesor = getProfesorByID(id);

        profesor.setNombre("Nombre cambiado");
        profesor.setEmail("correo@correo.es");
        realm.insertOrUpdate(profesor);
        realm.commitTransaction();
    }

    public static void deleteByID(int id) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Profesor profesor = getProfesorByID(id);
        profesor.deleteFromRealm();
        realm.commitTransaction();
    }

    public static void deleteAllProfesor() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.delete(Profesor.class);
        realm.commitTransaction();
    }
}
