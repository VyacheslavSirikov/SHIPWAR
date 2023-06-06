package com.example.shipwar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class game_menu extends AppCompatActivity implements View.OnClickListener {
    Button SButton1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);

        SButton1 = findViewById(R.id.START_BUTTON1);
        SButton1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == SButton1) {
            Intent intent = new Intent(this, ship_position_menu.class);
            startActivity(intent);
        }
    }
}
