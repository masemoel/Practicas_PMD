package com.masemoel.oncheckedchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup diassemana;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diassemana = (RadioGroup) findViewById(R.id.diassemana);
        textView = (TextView) findViewById(R.id.textView);

        diassemana.setOnCheckedChangeListener((diassemana, i) -> {
            RadioButton radioButton = findViewById(i);
            textView.setText(radioButton.getText().toString());
        });
    }
}