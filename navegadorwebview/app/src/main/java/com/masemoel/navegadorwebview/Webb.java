package com.masemoel.navegadorwebview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webb extends AppCompatActivity {
    WebView pagWeb;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webb);
        cargarWeb();
    }

    public void cargarWeb() {
        pagWeb = findViewById(R.id.pagWeb);
        pagWeb.setWebViewClient(new WebViewClient());
        bundle = getIntent().getExtras();
        pagWeb.loadUrl("https://"+bundle.getString("pagina"));

        // Habilitar JavaScript
        WebSettings webSettings = pagWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}