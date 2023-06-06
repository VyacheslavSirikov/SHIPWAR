package com.example.shipwar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//gh

public class activity_main extends AppCompatActivity implements View.OnClickListener {
    TextView[][] textViews1 = new TextView[10][10];
    int[][] values3 = new int[10][10];
    TextView[][] textViews2 = new TextView[10][10];
    int[][] values4 = new int[10][10];
    int[][] values2;
    int[][] values;
    int counter1 = 20;
    int counter2 = 20;
    boolean eye1Pressed = false;
    boolean eye2Pressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if (intent != null) {
            values2 = (int[][]) intent.getSerializableExtra("values2Array");
            values = (int[][]) intent.getSerializableExtra("valuesArray");
        }
        for (int i = 0; i < 10; i++) {
            char letter = (char) ('A' + i);
            for (int j = 0; j < 10; j++) {
                int textViewId = getResources().getIdentifier("v" + letter + "x" + (j + 1), "id", getPackageName());
                textViews1[i][j] = findViewById(textViewId);
                textViews1[i][j].setOnClickListener(this);
                values3[i][j] = 0;
            }
        }

        for (int i = 0; i < 10; i++) {
            char letter = (char) ('A' + i);
            for (int j = 0; j < 10; j++) {
                int textViewId = getResources().getIdentifier("v2" + letter + "x" + (j + 1), "id", getPackageName());
                textViews2[i][j] = findViewById(textViewId);
                textViews2[i][j].setOnClickListener(this);
                values4[i][j] = 0;
            }
        }

        ImageButton eye1Button = findViewById(R.id.eye1);
        eye1Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    eye1Pressed = true;
                    updateTextViewColors();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    eye1Pressed = false;
                    updateTextViewColors();
                }
                return true;
            }
        });

        ImageButton eye2Button = findViewById(R.id.eye2);
        eye2Button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    eye2Pressed = true;
                    updateTextViewColors();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    eye2Pressed = false;
                    updateTextViewColors();
                }
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        // Определите, какая ячейка была нажата
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (view == textViews2[i][j]) {
                    // Ячейка textViews2[i][j] была нажата
                    // Выполните нужные действия здесь
                    if (values2[i][j] == 1) {
                        textViews2[i][j].setBackgroundColor(Color.RED);
                        counter1--;
                    } else {
                        textViews2[i][j].setBackgroundColor(Color.GRAY);
                    }
                    values3[i][j] = values2[i][j];

                    if (counter1 <= 0) {
                        // Переход на класс WinPlayer1
                        Intent intent = new Intent(activity_main.this, win_player1.class);
                        startActivity(intent);
                    }
                    return;
                } else if (view == textViews1[i][j]) {
                    // Ячейка textViews1[i][j] была нажата
                    // Выполните нужные действия здесь
                    if (values[i][j] == 1) {
                        textViews1[i][j].setBackgroundColor(Color.RED);
                        counter2--;
                    } else {
                        textViews1[i][j].setBackgroundColor(Color.GRAY);
                    }
                    values4[i][j] = values[i][j];

                    if (counter2 <= 0) {
                        // Переход на класс WinPlayer2
                        Intent intent = new Intent(activity_main.this, win_player2.class);
                        startActivity(intent);
                    }
                    return;
                }
            }
        }
    }

    private void updateTextViewColors() {
        // Определите, какой цвет использовать для закрашенных ячеек
        int colorForEye1Pressed = Color.BLACK; // Цвет для eye1Pressed = true
        int colorForEye2Pressed = Color.BLACK; // Цвет для eye2Pressed = true

        // Обновите цвета ячеек
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (values2[i][j] == 1) {
                    if (eye1Pressed) {
                        textViews2[i][j].setBackgroundColor(colorForEye1Pressed);
                    } else if (values3[i][j] == 1) {
                        textViews2[i][j].setBackgroundColor(Color.RED);
                    } else {
                        textViews2[i][j].setBackgroundColor(Color.WHITE);
                    }
                }
                if (values[i][j] == 1) {
                    if (eye2Pressed) {
                        textViews1[i][j].setBackgroundColor(colorForEye2Pressed);
                    } else if (values4[i][j] == 1) {
                        textViews1[i][j].setBackgroundColor(Color.RED);
                    } else {
                        textViews1[i][j].setBackgroundColor(Color.WHITE);
                    }
                }
            }
        }
    }
}



