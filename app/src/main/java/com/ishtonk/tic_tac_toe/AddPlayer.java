package com.ishtonk.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        final EditText playerOne = findViewById(R.id.playerOneName);
        final EditText playerTwo = findViewById(R.id.playerTwoName);
        final Button startGame = findViewById(R.id.startGameBtn);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String playerOneName = playerOne.getText().toString();
                final String playerTwoName = playerTwo.getText().toString();

                if (playerOneName.isEmpty() || playerTwoName.isEmpty()) {
                    playerOne.setError("Player one name is required");
                    playerTwo.setError("Player two name is required");
                } else {
                    Intent intent = new Intent(AddPlayer.this, MainActivity.class);
                    intent.putExtra("playerOneName", playerOneName);
                    intent.putExtra("playerTwoName", playerTwoName);
                    startActivity(intent);
                }
            }
        });
    }
}