package com.example.settingthealpha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    ImageView chiselsImage;
    ImageView crosscutSawImage;
    SeekBar chiselsSeekBar;
    SeekBar crosscutSeekBar;
    float alphaLevel;

    /** We obtain references to this activity's layout and widgets,<br/>
     * in order to do so we call {@link #setContentView(View)} which connects this activity and its layout,<br/>
     * <b>without that method call we couldn't refer widgets</b>. */
    private void initWidgets() {
        setContentView(R.layout.activity_main);

        // Set reference between local fields (variables) and this activity's widgets.
        chiselsImage = findViewById(R.id.firstImage);
        crosscutSawImage = findViewById(R.id.secondImage);
        chiselsSeekBar = findViewById(R.id.firstSeekBar);
        crosscutSeekBar = findViewById(R.id.secondSeekBar);

        initWidgetsListeners();
    }

    /** We "tell" android which {@link View}s listen to what events in `this` (activity's) context:
     * @implNote
     * <p>Currently we have only 2 {@link SeekBar} widgets.</p><br/>
     * <p>We tell android the {@link SeekBar}s listen to {@link SeekBar#setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener)} events.</p> */
    private void initWidgetsListeners() {
        /* We tell android that `chiselsSeekBar` in `this` context listens to changes,
        for the `SeekBar` widget, the changes can be: `onProgressChanged`, `onStartTrackingTouch` and `onStopTrackingTouch` */
        chiselsSeekBar.setOnSeekBarChangeListener(this);
        crosscutSeekBar.setOnSeekBarChangeListener(this);
    }

    private void calibrateSeekBarWidgets() {
        chiselsSeekBar.setMax(100);
        crosscutSeekBar.setMax(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgets();
        calibrateSeekBarWidgets();
    }

    /** This method describes what we should do once a {@link SeekBar} in this screen (activity) was interacted with and changed.
     *
     * @implNote
     * <p>The chronological order of actions is (after the application is runnning):<br/>
     * 1. The user/code change the {@link SeekBar}'s value.<br/>
     * 2. Android "fires" an event into the open.<br/>
     * 3. Android calls the relevant method in this activity, which earlier registered for this type of event.</p><br/>
     * <p>This method is implemented in a very naive way.</p> */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == chiselsSeekBar) {
            alphaLevel = 1 - (float)progress/chiselsSeekBar.getMax();
            chiselsImage.setAlpha(alphaLevel);
        } else if (seekBar == crosscutSeekBar) {
            alphaLevel = 1 - (float)progress/crosscutSeekBar.getMax();
            crosscutSawImage.setAlpha(alphaLevel);
            chiselsImage.setAlpha(alphaLevel);
        } else {
            Log.e("Invalid seek bar tag", "Recieved `OnProgressChanged` event from an unknown `SeekBar` widget.");
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Log.d("Debugging onStartTrackingTouch", "Recieved `onStartTrackingTouch` event from a `SeekBar` widget.");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.d("Debugging onStopTrackingTouch", "Recieved `onStopTrackingTouch` event from a `SeekBar` widget.");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {}
}