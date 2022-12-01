package com.masemoel.notificacionanavegador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button notifbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button notifbutton = findViewById(R.id.notifbutton);
        notifbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificar();
            }
        });
    }

    public void notificar() {
        NotificationCompat.Builder creador;
        String canalID = "MiCanal01";
        Context contexto = getApplicationContext();
        NotificationManager notificador = (NotificationManager) getSystemService(contexto.NOTIFICATION_SERVICE);
        creador = new NotificationCompat.Builder(contexto, canalID);
        Intent intent = new Intent(this, WebActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(intent);
        PendingIntent resultPendingIntent =
            stackBuilder.getPendingIntent(0,
        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        // Si nuestro dispositivo tiene Android 8 (API 26, Oreo) o superior
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String canalNombre = "Mensajes";
            String canalDescribe = "Canal de mensajes";
            int importancia = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel miCanal = new NotificationChannel(canalID, canalNombre, importancia);
            miCanal.setDescription(canalDescribe);
            miCanal.enableVibration(true);
            notificador.createNotificationChannel(miCanal);
            creador = new NotificationCompat.Builder(contexto, canalID);
        }

        Bitmap iconoNotifica = BitmapFactory.decodeResource(contexto.getResources(), R.drawable.ic_launcher_background);
        int iconoSmall = R.drawable.ic_launcher_background;
        creador.setSmallIcon(iconoSmall);
        creador.setLargeIcon(iconoNotifica);
        creador.setContentTitle("Soy yo");
        String mensaje = "Púlsame para abrir el navegador.";
        creador.setContentText(mensaje);
        creador.setContentIntent(resultPendingIntent);
        creador.setStyle(new NotificationCompat.BigTextStyle().bigText(mensaje));
        creador.setChannelId(canalID);
        notificador.notify(1, creador.build());
    }
}