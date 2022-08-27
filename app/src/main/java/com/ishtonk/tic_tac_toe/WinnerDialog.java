package com.ishtonk.tic_tac_toe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinnerDialog extends Dialog {

    private final String message;
    private final MainActivity mainActivity;

    public WinnerDialog(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.winner_dialog_layout);

        final TextView winnerMessage = findViewById(R.id.winnerMessage);
        final Button restartGame = findViewById(R.id.restartGameBtn);

        winnerMessage.setText(message);

        restartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.restartGame();
                dismiss();
            }
        });
    }
}
