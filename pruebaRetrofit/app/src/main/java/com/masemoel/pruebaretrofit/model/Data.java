package com.masemoel.pruebaretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    private String count, next;
    @SerializedName("results")
    private List<Personaje> results;

    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }
    public void setNext(String next) {
        this.next = next;
    }

    public List<Personaje> getResults() {
        return results;
    }
    public void setResults(List<Personaje> results) {
        this.results = results;
    }
}