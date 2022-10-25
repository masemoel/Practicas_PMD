package com.masemoel.navegadorwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnGo;
    EditText txtURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarPagina(View view) {
        btnGo = (Button)findViewById(R.id.button);
        txtURL = (EditText)findViewById(R.id.urluser);
        Intent i = new Intent(this, Webb.class);

        // Envío el dato
        i.putExtra("pagina", txtURL.getText().toString());
        startActivity(i);
    }
}