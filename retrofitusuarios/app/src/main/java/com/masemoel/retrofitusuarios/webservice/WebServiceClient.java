package com.masemoel.retrofitusuarios.webservice;

import com.masemoel.retrofitusuarios.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface WebServiceClient {
    @GET("/api/users?page=2")
    Call<Data> getPersonajes();

    @GET()
    Call<Data> getPersonajes(@Url String url);
}