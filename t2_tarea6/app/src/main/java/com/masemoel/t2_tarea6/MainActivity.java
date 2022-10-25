package com.masemoel.t2_tarea6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnWebInsti;
    Button btnLlamar;
    Button btnLlamarInsti;
    Button btnInstiMaps;
    Button btnCamera;
    Button btnEnviarMail;
    Button btnContactos;
    Button btnJaenMaps;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLlamarInsti = (Button)findViewById(R.id.btnLlamarInsti);
        btnInstiMaps = (Button)findViewById(R.id.btnInstiMaps);
        btnCamera = (Button)findViewById(R.id.btnCamera);
        btnEnviarMail = (Button)findViewById(R.id.btnEnviarMail);
        btnContactos = (Button)findViewById(R.id.btnContactos);
        btnJaenMaps = (Button)findViewById(R.id.btnJaenMaps);
        btnLlamar = (Button)findViewById(R.id.btnLlamar);
        btnWebInsti = (Button)findViewById(R.id.btnWebInsti);
    }

    public void verWebInsti (View v){
        i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.fuentezuelas.com/"));
        startActivity(i);
    }

    public void mapaInstituto(View v){
        i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q=IES Las fuentezuelas Jaen"));
        startActivity(i);
    }

    public void verContactos(View v){
        i = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
        startActivity(i);
    }

    public void mapsJaen(View v){
        i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q=Jaen"));
        startActivity(i);
    }

    public void llamarInstituto(View v){
        i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:974243477"));
        startActivity(i);
    }

    public void llamarTelefono(View v){
        i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
        startActivity(i);
    }

    public void hacerFoto(View v){
        i = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(i);
    }

    public void enviarMail(View v){
        i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "Soy una buena app");
        i.putExtra(Intent.EXTRA_TEXT, "Viva Android");
        i.putExtra(Intent.EXTRA_EMAIL, "mmoreli163@g.educaand.es");
        startActivity(i);
    }
}