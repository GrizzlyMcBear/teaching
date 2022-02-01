package com.example.backgroundradiocolors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RelativeLayout relativeLayout;

    private void updateWidgets() {

        // Refer the layout (so we could change its bg color)
        relativeLayout = findViewById(R.id.rLayOut);

        // Refer to the radio button group
        radioGroup = findViewById(R.id.radioGroup);

        /* Setup an event listener (onCheckedChanged)
            we override listener method `onCheckedChanged` in this anonymous object
            so we could set the layout's bg color.
         */
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // Todo: SE (Students Exercise) ask during class for code improvements suggestions.
                switch (i) {
                    case R.id.red:
                        relativeLayout.setBackgroundColor(getResources().getColor(R.color.red));
                        break;
                    case R.id.blue:
                        relativeLayout.setBackgroundColor(getResources().getColor(R.color.blue));
                        break;
                    case R.id.green:
                        relativeLayout.setBackgroundColor(getResources().getColor(R.color.green));
                        break;
                    case R.id.yellow:
                        relativeLayout.setBackgroundColor(getResources().getColor(R.color.yellow));
                        break;
                    case R.id.purple:
                        relativeLayout.setBackgroundColor(getResources().getColor(R.color.purple));
                        break;
                    default:
                        // handle the default situation
                        break;
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateWidgets();
    }
}