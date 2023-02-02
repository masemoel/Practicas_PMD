package com.masemoel.pruebarealm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.masemoel.pruebarealm.crud.ProfesorCRUD;
import com.masemoel.pruebarealm.modelo.Curso;
import com.masemoel.pruebarealm.modelo.Profesor;

public class MainActivity extends AppCompatActivity {
    private Profesor profesor;
    private EditText nombre;
    private EditText email;
    private Button botonGuardar;
    private Button botonVer;
    private Button botonBuscar;
    private Button botonBuscarID;
    private Button botonUpdate;
    private Button botonEliminarAll;
    private Button botonEliminarID;
    private Button botonCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configurarVista();

    }

    private void configurarVista() {
        profesor = new Profesor();

        nombre = findViewById(R.id.editTextNombre);
        email = findViewById(R.id.editTextEmail);
        botonGuardar = findViewById(R.id.botonGuardar);
        botonVer = findViewById(R.id.botonVer);
        botonBuscar = findViewById(R.id.botonBuscarNombre);
        botonBuscarID = findViewById(R.id.botonBuscarID);
        botonUpdate = findViewById(R.id.botonActualizar);
        botonEliminarID = findViewById(R.id.botonEliminarID);
        botonEliminarAll = findViewById(R.id.botonEliminarAll);
        botonCursos = findViewById(R.id.botonCursos);

        botonGuardar.setOnClickListener(v -> {
            profesor.setNombre(nombre.getText().toString());
            profesor.setEmail(email.getText().toString());
            ProfesorCRUD.addProfesor(profesor);
        });

        botonVer.setOnClickListener(v -> {
            for (Profesor p : ProfesorCRUD.getAllProfesores()) {
                Log.d("PROF", p.toString());
                for (Curso curso : p.getCursos()) {
                    Log.d("CURSO ", curso.toString());
                }
            }
        });

        botonBuscar.setOnClickListener(v -> {
            Profesor p = ProfesorCRUD.getProfesorByName(nombre.getText().toString());
            if (p != null) {
                Log.d("TAG", p.toString());
            }
        });

        botonBuscarID.setOnClickListener(v -> {
            Profesor p = ProfesorCRUD.getProfesorByID(Integer.parseInt(nombre.getText().toString()));
            if (p != null) {
                Log.d("TAG", p.toString());
            }
        });

        botonUpdate.setOnClickListener(v -> {
            ProfesorCRUD.updateByID(Integer.parseInt(nombre.getText().toString()));
        });

        botonEliminarID.setOnClickListener(v -> {
            ProfesorCRUD.deleteByID(Integer.parseInt(nombre.getText().toString()));
        });

        botonEliminarAll.setOnClickListener(v -> {
            ProfesorCRUD.deleteAllProfesor();
        });

        botonCursos.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), CursosActivity.class));
        });
    }
}
