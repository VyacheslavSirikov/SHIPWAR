package com.example.shipwar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView vAx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vAx1 = findViewById(R.id.vAx1);
        vAx1.setOnClickListener(v -> {
            vAx1.setText("0");
        });
    }
}
