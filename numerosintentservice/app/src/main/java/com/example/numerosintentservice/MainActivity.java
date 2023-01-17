package com.example.numerosintentservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button genbutton;
    TextView numstext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genbutton = findViewById(R.id.genbutton);
        numstext = findViewById(R.id.numstext);

        genbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msgIntent = new Intent(MainActivity.this, NumerosIntentService.class);
                startService(msgIntent);

            }
        });

        IntentFilter filter = new IntentFilter();
        filter.addAction(NumerosIntentService.ACTION_PROGRESO);
        filter.addAction(NumerosIntentService.ACTION_FIN);
        ProgressReceiver rcv = new ProgressReceiver();
        registerReceiver(rcv, filter);
    }

    public class ProgressReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(NumerosIntentService.ACTION_PROGRESO)) {
                int num = intent.getIntExtra("numeros", 0);
                numstext.setText(numstext.getText()+"\n"+num);
            }
            else if(intent.getAction().equals(NumerosIntentService.ACTION_FIN)) {
                Toast.makeText(MainActivity.this, "Tarea finalizada!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}