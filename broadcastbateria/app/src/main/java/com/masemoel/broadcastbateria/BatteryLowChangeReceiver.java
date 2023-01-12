package com.masemoel.broadcastbateria;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.provider.Settings;
import android.widget.Toast;

public class BatteryLowChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        if (level <= 15) {
            Toast.makeText(context, "La carga de tu batería es baja ("+level+"%)", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "La carga de tu batería no es baja ("+level+"%)", Toast.LENGTH_SHORT).show();
        }
    }
}