package com.masemoel.final1trimestre.listsimpsons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    ImageView imageView;
    List<String> personajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listView);
        imageView = (ImageView) findViewById(R.id.imageView);

        personajes = new ArrayList<>();
        personajes.add("Homer Simpson");
        personajes.add("Marge Simpson");
        personajes.add("Bart Simpson");
        personajes.add("Lisa Simpson");
        personajes.add("Maggie Simpson");

        ArrayAdapter<String> adaptadorPersonajes = new ArrayAdapter<String>(
               this,
               android.R.layout.simple_list_item_1,
                personajes
        );
        lista.setAdapter(adaptadorPersonajes);
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        switch (posicion) {
            case 0:
                imageView.setImageResource(R.drawable.homer);
                break;
            case 1:
                imageView.setImageResource(R.drawable.marge);
                break;
            case 2:
                imageView.setImageResource(R.drawable.bart);
                break;
            case 3:
                imageView.setImageResource(R.drawable.lisa);
                break;
            case 4:
                imageView.setImageResource(R.drawable.maggie);
        }
    }
}