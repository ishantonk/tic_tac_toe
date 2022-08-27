package com.ishtonk.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<int[]> combinationsList = new ArrayList<>();

    private int[] gameState = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    private int activePlayer = 1;

    private int totalSelectedBoxes = 1;

    private LinearLayout playerOneLayout, playerTwoLayout;
    private TextView playerOneName, playerTwoName;
    private ImageView cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneName = findViewById(R.id.playerOneNameText);
        playerTwoName = findViewById(R.id.playerTwoNameText);

        playerOneLayout = findViewById(R.id.playerOneName);
        playerTwoLayout = findViewById(R.id.playerTwoName);

        cell1 = findViewById(R.id.cell1);
        cell2 = findViewById(R.id.cell2);
        cell3 = findViewById(R.id.cell3);
        cell4 = findViewById(R.id.cell4);
        cell5 = findViewById(R.id.cell5);
        cell6 = findViewById(R.id.cell6);
        cell7 = findViewById(R.id.cell7);
        cell8 = findViewById(R.id.cell8);
        cell9 = findViewById(R.id.cell9);

        combinationsList.add(new int[]{0, 1, 2});
        combinationsList.add(new int[]{3, 4, 5});
        combinationsList.add(new int[]{6, 7, 8});
        combinationsList.add(new int[]{0, 3, 6});
        combinationsList.add(new int[]{1, 4, 7});
        combinationsList.add(new int[]{2, 5, 8});
        combinationsList.add(new int[]{0, 4, 8});
        combinationsList.add(new int[]{2, 4, 6});

        final String getPlayerOneName = getIntent().getStringExtra("playerOneName");
        final String getPlayerTwoName = getIntent().getStringExtra("playerTwoName");

        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        playerOneLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        playerTwoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        cell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxTaken(0)) {
                    playMove((ImageView) view, 0);
                }
            }
        });

        cell2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxTaken(1)) {
                    playMove((ImageView) view, 1);
                }
            }
        });

        cell3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxTaken(2)) {
                    playMove((ImageView) view, 2);
                }
            }
        });

        cell4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxTaken(3)) {
                    playMove((ImageView) view, 3);
                }
            }
        });

        cell5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxTaken(4)) {
                    playMove((ImageView) view, 4);
                }
            }
        });

        cell6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxTaken(5)) {
                    playMove((ImageView) view, 5);
                }
            }
        });

        cell7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxTaken(6)) {
                    playMove((ImageView) view, 6);
                }
            }
        });

        cell8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxTaken(7)) {
                    playMove((ImageView) view, 7);
                }
            }
        });

        cell9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxTaken(8)) {
                    playMove((ImageView) view, 8);
                }
            }
        });

    }

    private void playMove(ImageView imageView, int position) {

        gameState[position] = activePlayer;

        if(activePlayer == 1) {
            imageView.setImageResource(R.drawable.cross);

            if (checkWinner()) {
                Dialog winnerDialog = new WinnerDialog(MainActivity.this, playerOneName.getText().toString() + " is the winner!", MainActivity.this);
                winnerDialog.setCancelable(false);
                winnerDialog.show();
            } else if (totalSelectedBoxes == 9) {
                Dialog winnerDialog = new WinnerDialog(MainActivity.this, " It is a Tie!", MainActivity.this);
                winnerDialog.setCancelable(false);
                winnerDialog.show();
            } else {
                changeActivePlayer(2);
                totalSelectedBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.circle);

            if (checkWinner()) {
                Dialog winnerDialog = new WinnerDialog(MainActivity.this, playerTwoName.getText().toString() + " is the winner!", MainActivity.this);
                winnerDialog.setCancelable(false);
                winnerDialog.show();
            } else if (totalSelectedBoxes == 9) {
                Dialog winnerDialog = new WinnerDialog(MainActivity.this, " It is a Tie!", MainActivity.this);
                winnerDialog.setCancelable(false);
                winnerDialog.show();
            } else {
                changeActivePlayer(1);
                totalSelectedBoxes++;
            }
        }
    }

    private void changeActivePlayer(int currentActivePlayer) {
        activePlayer = currentActivePlayer;

        if (activePlayer == 1) {
            playerOneLayout.setBackgroundResource(R.drawable.player_info_active);
            playerTwoLayout.setBackgroundResource(R.drawable.player_info_inactive);
        } else {
            playerOneLayout.setBackgroundResource(R.drawable.player_info_inactive);
            playerTwoLayout.setBackgroundResource(R.drawable.player_info_active);
        }
    }

    private boolean checkWinner() {

        boolean response = false;

        for (int i = 0; i < combinationsList.size(); i++) {
            final int[] combination = combinationsList.get(i);

            if (gameState[combination[0]] == activePlayer && gameState[combination[1]] == activePlayer && gameState[combination[2]] == activePlayer) {
                response = true;
            }
        }
        return response;
    }

    private boolean isBoxTaken(int position) {
        boolean response = false;
        if (gameState[position] == 0) {
            response = true;
        }

        return response;
    }

    public void restartGame() {
        totalSelectedBoxes = 1;
        activePlayer = 1;

        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 0;
        }
        cell1.setImageResource(R.drawable.transparent_background);
        cell2.setImageResource(R.drawable.transparent_background);
        cell3.setImageResource(R.drawable.transparent_background);
        cell4.setImageResource(R.drawable.transparent_background);
        cell5.setImageResource(R.drawable.transparent_background);
        cell6.setImageResource(R.drawable.transparent_background);
        cell7.setImageResource(R.drawable.transparent_background);
        cell8.setImageResource(R.drawable.transparent_background);
        cell9.setImageResource(R.drawable.transparent_background);
    }
}