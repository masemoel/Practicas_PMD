package com.masemoel.pruebarealm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.masemoel.pruebarealm.crud.CursoCRUD;
import com.masemoel.pruebarealm.modelo.Curso;

public class CursosActivity extends AppCompatActivity {
    private EditText editTextID;
    private EditText editTextNombre;
    private EditText editTextDuracion;
    private Button buttonAgregar;
    private Button buttonEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        editTextID = findViewById(R.id.editTextID);
        editTextNombre = findViewById(R.id.editTextNombreCurso);
        editTextDuracion = findViewById(R.id.editTextDuracionCurso);
        buttonAgregar = findViewById(R.id.botonAgregarCurso);
        buttonEdit = findViewById(R.id.botonEditaCurso);

        buttonAgregar.setOnClickListener(v -> {
            CursoCRUD.addCurso(editTextID.getText().toString(),
                    new Curso(editTextNombre.getText().toString(), editTextDuracion.getText().toString()));

        });

        buttonEdit.setOnClickListener(v -> {
            CursoCRUD.updateByNombre(editTextNombre.getText().toString());
        });
    }
}
