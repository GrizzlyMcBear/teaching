package com.example.intentwithradio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    RadioGroup radioGroup1, radioGroup2;
    Button backButton;
    TextView myPointsTextView;
    Map<Integer, Integer> correctResponses = new HashMap<>();
    int myPoints;

    private void initWidgets() {
        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        backButton = findViewById(R.id.backButton);
        myPointsTextView = findViewById(R.id.my_points_tv);

        initEventHandlers();
    }

    private void initEventHandlers() {
        backButton.setOnClickListener(this);
        radioGroup1.setOnCheckedChangeListener(this);
        radioGroup2.setOnCheckedChangeListener(this);
    }

    private void initData() {
        correctResponses.put(R.id.radioGroup1, R.id.group1answer2);
        correctResponses.put(R.id.radioGroup2, R.id.group2answer4);
        myPoints = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initWidgets();
        initData();
    }

    @Override
    public void onClick(View view) {
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        if (!correctResponses.containsKey(radioGroup.getId())) {
            Toast.makeText(this, "Unknown question!", Toast.LENGTH_LONG)
                    .show();
        } else {
            if (correctResponses.get(radioGroup.getId()).equals(checkedId)) {
                Toast.makeText(this, "Correct answer :)", Toast.LENGTH_SHORT)
                        .show();
                myPoints++;
            } else {
                Toast.makeText(this, "Wrong answer :(", Toast.LENGTH_SHORT)
                        .show();
                myPoints--;
            }

            myPointsTextView.setText(String.format("%s %s", this.getString(R.string.my_points), myPoints));
        }
    }
}