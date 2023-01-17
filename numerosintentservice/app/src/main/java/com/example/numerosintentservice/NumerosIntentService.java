package com.example.numerosintentservice;

import android.app.IntentService;
import android.content.Intent;

public class NumerosIntentService extends IntentService {
    public static final String ACTION_PROGRESO = "com.example.numerosintentservice.intent.action.PROGRESO";
    public static final String ACTION_FIN = "com.example.numerosintentservice.intent.action.FIN";

    public NumerosIntentService() {
        super("NumerosIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for (int i=1;i<=100;i*=2) {
            tareaLarga();
            //Comunicamos el progreso
            Intent bcIntent = new Intent();
            bcIntent.setAction(ACTION_PROGRESO);
            bcIntent.putExtra("numeros", i);
            sendBroadcast(bcIntent);
        }

        Intent bcIntent = new Intent();
        bcIntent.setAction(ACTION_FIN);
        sendBroadcast(bcIntent);
    }

    private void tareaLarga() {
        try {
            Thread.sleep(500);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}