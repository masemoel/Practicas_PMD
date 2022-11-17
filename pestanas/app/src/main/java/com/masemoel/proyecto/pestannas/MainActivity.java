package com.masemoel.proyecto.pestannas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos un icono del sistema
        Resources recursos = getResources();
        Drawable icono1 = ContextCompat.getDrawable(this, android.R.drawable.ic_secure);

        // Empezaremos obteniendo una referencia al control principal TabHost
        TabHost tabs = findViewById(R.id.tabhost);

        // Lo preparamos para su configuración
        tabs.setup();

        /* Crearemos un objeto de tipo TabSpec (pestaña) para cada uno de las pestañas que
        queramos añadir mediante el método newTabSpec(), al que pasaremos como
        parámetro una etiqueta identificatia de la pestaña*/
        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");

        // Le asignaremos el layout de un contenido correspondiente a la pestaña
        spec.setContent(R.id.tab1);

        /* Indicaremos el texto y el icono que queremos mostrar a la pestaña
        mediante el método setIndicator(texto, icono)*/
        spec.setIndicator("TAB1",icono1);

        // Añadimos la pestaña recien creada
        tabs.addTab(spec);

        // Repetimos el proceso para cada una de las pestañas
        spec = tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("CONTACTO", icono1);
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("", icono1);
    }
}