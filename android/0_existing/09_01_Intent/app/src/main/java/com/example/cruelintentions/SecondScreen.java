package com.example.cruelintentions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondScreen extends AppCompatActivity implements View.OnClickListener {

    Button goBackBtn;

    private void initWidgets() {
        setContentView(R.layout.activity_second_screen);
        goBackBtn = findViewById(R.id.goBackBtn);
        goBackBtn.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgets();
    }

    @Override
    public void onClick(View view) {
        // Behaviour 1: create a new activity of the first screen
        Intent screenRewindIntent = new Intent(this, MainActivity.class);
        startActivity(screenRewindIntent);

        // Behaviour 2: kill the current screen
//        finish();
    }
}