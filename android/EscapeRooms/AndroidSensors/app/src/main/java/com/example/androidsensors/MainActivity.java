package com.example.androidsensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author Ronen Cohen
 * @since 2021.11.15
 * @version 1.0.0.0
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button environmentSensorsNavButton;
    Button soundSensorNavButton;

//    SensorManager sensorManager;

    private void initApp() {
        initSensors();
        initWidgets();
    }

    private void initSensors() {
        // Get an instance of the sensor service, to get an instance of a particular sensor.
//        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    /** This method initializes the local fields referring this activity's views.
     *
     * @implNote We set data in the {@link android.view.View} component by calling the
     * <a href="#{@link}">{@link android.view.View#setTag(Object) setTag()}</a> and setting a tag with data
     * which is relevant to that particular View.
     */
    private void initWidgets() {
        environmentSensorsNavButton = findViewById(R.id.environmentSensorsScreenNavButton);
        environmentSensorsNavButton.setTag(R.id.destination_activity_class, EnvironmentSensorsActivity.class);

        soundSensorNavButton = findViewById(R.id.soundSensorScreenNavButton);
        soundSensorNavButton.setTag(R.id.destination_activity_class, SoundSensorsActivity.class);

        initWidgetsHandlers();
    }

    private void initWidgetsHandlers() {
        environmentSensorsNavButton.setOnClickListener(this);
        soundSensorNavButton.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initApp();
    }

    @Override
    public void onClick(View view) {
        Intent sensorScreenIntent = new Intent(this, (Class<?>) view.getTag(R.id.destination_activity_class));

        startActivity(sensorScreenIntent);
    }
}