package com.masemoel.noticiassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private EditText edCodigo, edTitular, edTexto, edFecha, edUrlimagen;
    private Button btnInsertar, btnActualizar, btnEliminar, btnConsultar;
    private TextView txtResultado; // TODO: switch to ListView!
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edCodigo = (EditText)findViewById(R.id.edCodigo);
        edTitular = (EditText)findViewById(R.id.edTitular);
        edTexto = (EditText)findViewById(R.id.edTexto);
        edFecha = (EditText)findViewById(R.id.edFecha);
        edUrlimagen = (EditText)findViewById(R.id.edUrlimagen);
        txtResultado = (TextView)findViewById(R.id.txtResultado);

        btnInsertar = (Button)findViewById(R.id.btnInsertar);
        btnActualizar = (Button)findViewById(R.id.btnActualizar);
        btnEliminar = (Button)findViewById(R.id.btnEliminar);
        btnConsultar = (Button)findViewById(R.id.btnConsultar);

        //Abrimos la base de datos 'DBNoticias' en modo escritura
        NoticiasSQLiteHelper notisdbh = new NoticiasSQLiteHelper(this, "DBNoticias.db", null, 2);

        db = notisdbh.getWritableDatabase();

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String cod = edCodigo.getText().toString();
                String tit = edTitular.getText().toString();
                String tex = edTexto.getText().toString();
                String fec = edFecha.getText().toString();
                String url = edUrlimagen.getText().toString();

                //Alternativa 1: método sqlExec()
                //String sql = "INSERT INTO Noticias (codigo,nombre) VALUES ('" + cod + "','" + nom + "') ";
                //db.execSQL(sql);

                //Alternativa 2: método insert()
                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("codigo", cod);
                nuevoRegistro.put("titular", tit);
                nuevoRegistro.put("texto", tex);
                nuevoRegistro.put("fecha", fec);
                nuevoRegistro.put("urlimagen", url);
                db.insert("Noticias", null, nuevoRegistro);

                //Alternativa 3: con parámetros
//                String[] args = new String[]{cod, nom};
//                    db.execSQL("INSERT INTO Noticias (codigo, nombre) VALUES (?, ?)", args);
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Recuperamos los valores de los campos de texto
                String cod = edCodigo.getText().toString();
                String tit = edTitular.getText().toString();
                String tex = edTexto.getText().toString();
                String fec = edFecha.getText().toString();
                String url = edUrlimagen.getText().toString();

                //Alternativa 1: método sqlExec()
                //String sql = "UPDATE Noticias SET nombre='" + nom + "' WHERE codigo=" + cod;
                //db.execSQL(sql);

                //Alternativa 2: método update()
                ContentValues valores = new ContentValues();
                valores.put("titular", tit);
                valores.put("texto", tex);
                valores.put("fecha", fec);
                valores.put("urlimagen", url);
                db.update("Noticias", valores, "codigo=" + cod, null);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Recuperamos los valores de los campos de texto
                String cod = edCodigo.getText().toString();

                //Alternativa 1: método sqlExec()
                //String sql = "DELETE FROM Noticias WHERE codigo=" + cod;
                //db.execSQL(sql);

                //Alternativa 2: método delete()
                db.delete("Noticias", "codigo=" + cod, null);
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Alternativa 1: método rawQuery()
                Cursor c = db.rawQuery("SELECT codigo, titular, texto, fecha, urlimagen FROM Noticias", null);

                //Alternativa 2: método query()
                //String[] campos = new String[] {"codigo", "nombre"};
                //Cursor c = db.query("Noticias", campos, null, null, null, null, null);

                //Recorremos los resultados para mostrarlos en pantalla
                txtResultado.setText("");
                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya más registros
                    do {
                        String cod = c.getString(0);
                        String tit = c.getString(1);
                        String tex = c.getString(2);
                        String fec = c.getString(3);
                        String url = c.getString(4);
                        txtResultado.append(" " + cod + " - " + tit + " - " + tex + " - " + fec + " - " + url + " - " +  "\n");
                    } while(c.moveToNext());
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Cerramos la base de datos
        db.close();
    }

    protected void insertar(int codigo, String titular, String texto, String fecha, String urlimagen) {
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("codigo", codigo);
        nuevoRegistro.put("titular", titular);
        nuevoRegistro.put("texto", texto);
        nuevoRegistro.put("fecha", fecha);
        nuevoRegistro.put("urlimagen", urlimagen);
        db.insert("Noticias", null, nuevoRegistro);
    }
}