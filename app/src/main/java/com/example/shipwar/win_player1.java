package com.example.shipwar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class win_player1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_player1);

        Button restartButton = findViewById(R.id.REBUT);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на класс ShipPositionMenu
                Intent intent = new Intent(win_player1.this, ship_position_menu.class);
                startActivity(intent);
            }
        });
    }
}

