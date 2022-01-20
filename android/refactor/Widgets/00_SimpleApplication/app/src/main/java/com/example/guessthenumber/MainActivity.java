package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button increment;
    Button decrement;
    Button resetGame;
    Button checkNumber;

    int secretNumber;
    TextView userNumberTV;
    int userNumber;

    TextView userNotificationTV;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        initApp();
    }

    // Initializes variables for the app i.e. reset the number to be guessed
    private void initApp() {
        random = new Random();
        resetGame();
    }

    private void resetGame() {
        secretNumber = random.nextInt(10);
        userNumber = 5;
        userNumberTV.setText(Integer.toString(userNumber));
    }

    // Initialize the widgets i.e. connect the fields to their matching widgets, set the event listeners etc.
    private void initWidgets() {
        userNumberTV = findViewById(R.id.userNumber);
        userNotificationTV = findViewById(R.id.userNotification);

        increment = findViewById(R.id.increment);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNumber += 1;
                userNumberTV.setText(userNumber+"");
            }
        });

        decrement = findViewById(R.id.decrement);
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNumber -= 1;
                userNumberTV.setText(userNumber+"");
            }
        });

        checkNumber = findViewById(R.id.checkNumber);
        checkNumber.setOnClickListener(this);
        resetGame = findViewById(R.id.resetGame);
        resetGame.setOnClickListener(this);
    }

    public void playGameOnClick(View view) {
        Toast gamePlayingToast = Toast.makeText(
                getApplicationContext(),
                "Let's play the game.",
                Toast.LENGTH_SHORT);

        gamePlayingToast.show();
    }

    @Override
    public void onClick(View v) {
        if (v == checkNumber) {
            if (userNumber == secretNumber) {
                userNotificationTV.setText("Woo Hoo - You've guessed the number!!!");
            } else {
                userNotificationTV.setText("Almost there... try again");
            }
        } else if (v == resetGame) {
            resetGame();
        } else {
            Toast.makeText(getApplicationContext(), "You're mistaken - there is no such view.", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}