package com.masemoel.notificacionanavegador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
    WebView pagWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        cargarWeb();
    }

    public void cargarWeb() {
        pagWeb = findViewById(R.id.pagWeb);
        pagWeb.setWebViewClient(new WebViewClient());
        pagWeb.loadUrl("https://www.google.es/");

        // Habilitar JavaScript
        WebSettings webSettings = pagWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}