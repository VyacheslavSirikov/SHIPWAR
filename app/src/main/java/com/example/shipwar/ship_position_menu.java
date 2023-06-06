package com.example.shipwar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ship_position_menu extends AppCompatActivity implements View.OnClickListener {
    TextView[][] textViews = new TextView[10][10];
    int[][] values = new int[10][10];
    Button SButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ship_position_menu);

        SButton2 = findViewById(R.id.START_BUTTON2);
        SButton2.setOnClickListener(this);

        for (int i = 0; i < 10; i++) {
            char letter = (char) ('A' + i);
            for (int j = 0; j < 10; j++) {
                int textViewId = getResources().getIdentifier("v2" + letter + "x" + (j + 1), "id", getPackageName());
                textViews[i][j] = findViewById(textViewId);
                textViews[i][j].setOnClickListener(this);
                values[i][j] = 0;
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v == SButton2) {
            Intent intent = new Intent(this, ship_position_menu_2.class);
            intent.putExtra("valuesArray", values); // Передача массива values
            startActivity(intent);
        } else {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (v == textViews[i][j]) {
                        if (values[i][j] == 0) {
                            values[i][j] = 1;
                            textViews[i][j].setBackgroundColor(Color.BLACK);
                        } else {
                            values[i][j] = 0;
                            textViews[i][j].setBackgroundColor(Color.WHITE);
                        }
                        break;
                    }
                }
            }
        }
    }
}




