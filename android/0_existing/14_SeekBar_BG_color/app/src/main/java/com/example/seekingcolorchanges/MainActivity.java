package com.example.seekingcolorchanges;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar red, green, blue, alpha;
    LinearLayout linearLayout;

    private void initWidgets() {
        linearLayout = findViewById(R.id.linear);
        red = findViewById(R.id.red);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);
        alpha = findViewById(R.id.alpha);

        initWidgetsListeners();
    }

    private void initWidgetsListeners() {
        red.setOnSeekBarChangeListener(this);
        green.setOnSeekBarChangeListener(this);
        blue.setOnSeekBarChangeListener(this);
        alpha.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        linearLayout.setBackgroundColor(Color.argb(alpha.getProgress(),
                red.getProgress(), green.getProgress(), blue.getProgress()));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }
}