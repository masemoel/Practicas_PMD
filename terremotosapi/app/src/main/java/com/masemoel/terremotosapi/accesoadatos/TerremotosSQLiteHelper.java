package com.masemoel.terremotosapi.accesoadatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.masemoel.terremotosapi.model.Geometria;
import com.masemoel.terremotosapi.model.Propiedades;
import com.masemoel.terremotosapi.model.Terremoto;

import java.util.ArrayList;
import java.util.List;

public class TerremotosSQLiteHelper extends SQLiteOpenHelper {
    //Sentencia SQL para crear la tabla de terremotos
    String sqlCreate = "CREATE TABLE Terremotos (titulo TEXT, id TEXT, hora NUMERIC, tsunami INTEGER, longitud NUMERIC, latitud NUMERIC)";

    public TerremotosSQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        // NOTA: Por simplicidad del ejemplo aquí utilizamos directamente
        //       la opción de eliminar la tabla anterior y crearla de nuevo
        //       vacía con el nuevo formato.
        //       Sin embargo lo normal será que haya que migrar datos de la
        //       tabla antigua a la nueva, por lo que este método debería
        //       ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Terremotos");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }

    public void insertar(String titulo, String id, long hora, int tsunami, double longitud, double latitud, SQLiteDatabase db) {
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("titulo", titulo);
        nuevoRegistro.put("id", id);
        nuevoRegistro.put("hora", hora);
        nuevoRegistro.put("tsunami", tsunami);
        nuevoRegistro.put("longitud", longitud);
        nuevoRegistro.put("latitud", latitud);
        db.insert("Terremotos", null, nuevoRegistro);
    }

    public List<Terremoto> obtener(SQLiteDatabase db) {
        List<Terremoto> terremotos = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT titulo, id, hora, tsunami, longitud, latitud FROM Terremotos", null);
        if (c.moveToFirst()) {
            Terremoto t;
            Propiedades p;
            Geometria g;
            do {
                List<Float> coordenadas = new ArrayList<>();
                String titulo = c.getString(0);
                String id = c.getString(1);
                long hora = c.getLong(2);
                int tsunami = c.getInt(3);
                float longitud = c.getFloat(4);
                float latitud = c.getFloat(5);
                coordenadas.add(longitud);
                coordenadas.add(latitud);
                g = new Geometria(coordenadas);
                p = new Propiedades(hora, tsunami, titulo);
                t = new Terremoto(p, g, id);
                terremotos.add(t);
            } while(c.moveToNext());
        }
        return terremotos;
    }
}