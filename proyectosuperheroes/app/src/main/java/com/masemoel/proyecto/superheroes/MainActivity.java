package com.masemoel.proyecto.superheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView camaraboton;
    Button guardarboton;
    TextView nombreheroe, aliasheroe, biografiatext;
    RatingBar poderrating;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camaraboton = (ImageView)findViewById(R.id.camaraboton);
        guardarboton = (Button)findViewById(R.id.guardarboton);
        nombreheroe = (TextView)findViewById(R.id.nombreheroe);
        aliasheroe = (TextView)findViewById(R.id.aliasheroe);
        biografiatext = (TextView)findViewById(R.id.biografiatext);
        poderrating = (RatingBar)findViewById(R.id.poderrating);
    }

    public void hacerFoto(View v){
        i = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(i, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            camaraboton.setImageBitmap(photo);
        }
    }

    public void guardarHeroe(View view) {
        Intent y = new Intent(this, GuardadoHeroe.class);
        y.putExtra("nombreheroe", nombreheroe.getText().toString());
        y.putExtra("aliasheroe", aliasheroe.getText().toString());
        y.putExtra("biografiaheroe", biografiatext.getText().toString());
        y.putExtra("poderrating", poderrating.getRating());
        startActivity(y);
    }
}