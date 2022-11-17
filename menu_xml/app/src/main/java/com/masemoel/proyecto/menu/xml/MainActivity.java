package com.masemoel.proyecto.menu.xml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int MNU_OPC1 = 1;
    private static final int MNU_OPC2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, MNU_OPC1, Menu.NONE, "Opción 1").setIcon(android.R.drawable.ic_menu_preferences);
        menu.add(Menu.NONE, MNU_OPC2, Menu.NONE, "Opción 2").setIcon(android.R.drawable.ic_menu_info_details);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case MNU_OPC1:
                Toast.makeText(getApplicationContext(), "Opción 1", Toast.LENGTH_SHORT).show();
                return true;
            case MNU_OPC2:
                Toast.makeText(getApplicationContext(), "Opción 2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}