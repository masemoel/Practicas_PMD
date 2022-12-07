package com.masemoel.listview.controlesdeelementos;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private TextView tv2;
    private ListView lv1;
    private String[] cursos;
    private String[] asignaturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv2 = findViewById(R.id.textView2);
        lv1 = findViewById(R.id.list);

        asignaturas = getResources().getStringArray(R.array.opcion);
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, asignaturas);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView <?> adapterView, View v, int position, long id){
        v.animate().rotationX(368).setDuration(500).start();
    }
}