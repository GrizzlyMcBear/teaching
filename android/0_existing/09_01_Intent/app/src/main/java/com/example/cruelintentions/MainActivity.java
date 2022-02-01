package com.example.cruelintentions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button screenNavBtn;

    // Declare a dedicated method to handle the widgets' initialization
    private void initWidgets() {
        screenNavBtn = findViewById(R.id.screenNavBtn);
        screenNavBtn.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
    }

    @Override
    public void onClick(View view) {
        // Option 1: using extra variable (eases debugging)

        Intent screenNavigationIntent = new Intent(this, SecondScreen.class);
        startActivity(screenNavigationIntent);

        // Option 2: concise and to the point.
//        startActivity(new Intent(this, SecondScreen.class));
    }
}