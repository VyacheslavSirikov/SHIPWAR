package com.example.shipwar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ship_position_menu_2 extends AppCompatActivity implements View.OnClickListener {
    TextView[][] textViews = new TextView[10][10];
    int[][] values;
    int[][] values2 = new int[10][10];
    Button SButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ship_position_menu_2);

        SButton3 = findViewById(R.id.START_BUTTON3);
        SButton3.setOnClickListener(this);

        // Получение массива values1 из Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            values = (int[][]) extras.getSerializable("valuesArray");
        }

        for (int i = 0; i < 10; i++) {
            char letter = (char) ('A' + i);
            for (int j = 0; j < 10; j++) {
                int textViewId = getResources().getIdentifier("v" + letter + "x" + (j + 1), "id", getPackageName());
                textViews[i][j] = findViewById(textViewId);
                textViews[i][j].setOnClickListener(this);
                values2[i][j] = 0;
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v == SButton3) {
            Intent intent = new Intent(this, activity_main.class);
            intent.putExtra("valuesArray", values); // Передача массива values1
            intent.putExtra("values2Array", values2); // Передача массива values2
            startActivity(intent);
        } else {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (v == textViews[i][j]) {
                        if (values2[i][j] == 0) {
                            values2[i][j] = 1;
                            textViews[i][j].setBackgroundColor(Color.BLACK);
                        } else {
                            values2[i][j] = 0;
                            textViews[i][j].setBackgroundColor(Color.WHITE);
                        }
                        break;
                    }
                }
            }
        }
    }
}



