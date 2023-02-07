package com.masemoel.retrofitusuarios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.masemoel.retrofitusuarios.adapter.UsuarioAdapter;
import com.masemoel.retrofitusuarios.model.Data;
import com.masemoel.retrofitusuarios.model.Usuario;
import com.masemoel.retrofitusuarios.webservice.Api;
import com.masemoel.retrofitusuarios.webservice.WebServiceClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UsuarioAdapter adapter;
    private List<Usuario> usuarios;
    private Retrofit retrofit;
    private WebServiceClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        setUpView();
        lanzarPeticion();
    }

    private void lanzarPeticion() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Obteniendo datos del servidor. Espere...");
        progressDialog.show();
        (Api.getClient().getPersonajes()).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                progressDialog.dismiss();
                adapter.setData(response.body().getData());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("TAG", "Error: "+t.getMessage());
                Toast.makeText(RetrofitActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void setUpView() {
        usuarios = new ArrayList<>();
        adapter = new UsuarioAdapter(usuarios);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(lim);
        recyclerView.setAdapter(adapter);
    }
}