package com.masemoel.t2_tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView text2;
    Button button2;
    Button button3;

    public void setUserText() {
        Bundle bundle = getIntent().getExtras();
        text2.setText("usertext");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        text2 = findViewById(R.id.textView);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        setUserText();

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent result = new Intent();
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}