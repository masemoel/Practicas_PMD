package com.masemoel.proyecto.superheroes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class GuardadoHeroe extends AppCompatActivity {
    Bundle bundle;
    TextView nombreheroe, alias, biografia, podertitulo;
    RatingBar poderrating;
    ImageView imagenheroe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardado_heroe);

        nombreheroe = (TextView)findViewById(R.id.nombreheroe);
        alias = (TextView)findViewById(R.id.alias);
        biografia = (TextView)findViewById(R.id.biografia);
        podertitulo = (TextView)findViewById(R.id.podertitulo);
        poderrating = (RatingBar)findViewById(R.id.poderrating);
        imagenheroe = (ImageView)findViewById(R.id.imagenheroe);
        bundle = getIntent().getExtras();

        setTitle(bundle.getString("nombreheroe"));
        nombreheroe.setText(bundle.getString("nombreheroe"));
        alias.setText(bundle.getString("aliasheroe"));
        biografia.setText(bundle.getString("biografiaheroe"));
        poderrating.setRating(bundle.getFloat("poderrating"));
    }
}