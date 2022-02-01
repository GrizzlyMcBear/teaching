package com.example.swappingwithvectors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageButton back, forward;
    ImageView img;
    int counter = 1;

    private void initWidgets() {
        back = findViewById(R.id.back);
        forward = findViewById(R.id.forward);
        img = findViewById(R.id.image);
        initWidgetsListeners();
    }

    private void initWidgetsListeners() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                if (counter==0)
                    counter = 4;

                setImage();
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                if (counter==5)
                    counter = 1;

                setImage();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
    }

    // Todo: SE how (if at all) would you refactor this method?
    public void setImage() {
        switch (counter) {
            case 1:
                img.setImageResource(R.drawable.chisels);
                break;
            case 2:
                img.setImageResource(R.drawable.crosscut_saw);
                break;
            case 3:
                img.setImageResource(R.drawable.hand_drill);
                break;
            case 4:
                img.setImageResource(R.drawable.hand_plane);
                break;
        }
    }
}