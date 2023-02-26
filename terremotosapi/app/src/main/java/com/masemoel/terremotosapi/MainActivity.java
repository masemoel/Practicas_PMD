package com.masemoel.terremotosapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.masemoel.terremotosapi.accesoadatos.TerremotosSQLiteHelper;
import com.masemoel.terremotosapi.adapter.TerremotoAdapter;
import com.masemoel.terremotosapi.model.Data;
import com.masemoel.terremotosapi.model.Terremoto;
import com.masemoel.terremotosapi.webservice.Api;
import com.masemoel.terremotosapi.webservice.WebServiceClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TerremotoAdapter adapter;
    private List<Terremoto> terremotos;
    private Retrofit retrofit;
    private WebServiceClient client;
    private SQLiteDatabase db;
    TerremotosSQLiteHelper terrdbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        terrdbh = new TerremotosSQLiteHelper(this, "DBTerremotos.db", null, 2);
        db = terrdbh.getWritableDatabase();

        setUpView();
        lanzarPeticion();
    }

    private void lanzarPeticion() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Obteniendo datos del servidor. Espere...");
        progressDialog.show();
        (Api.getClient().getTerremotos()).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                List<Terremoto> newterrs = response.body().getFeatures();
                progressDialog.dismiss();
                //adapter.setData(response.body().getFeatures()); // OLD
                for (Terremoto t: newterrs) {
                    String titulo = t.getPropiedades().getTitle();
                    String id = t.getId();
                    long hora = t.getPropiedades().getTime();
                    int tsunami = t.getPropiedades().getTsunami();
                    double longitud = t.getGeometria().getCoordenadas().get(0);
                    double latitud = t.getGeometria().getCoordenadas().get(1);
                    terrdbh.insertar(titulo, id, hora, tsunami, longitud, latitud, db);
                }
                adapter.setData(terrdbh.obtener(db));
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("TAG", "Error: "+t.getMessage());
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void setUpView() {
        terremotos = new ArrayList<>();
        adapter = new TerremotoAdapter(terremotos);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(lim);
        recyclerView.setAdapter(adapter);
    }
}