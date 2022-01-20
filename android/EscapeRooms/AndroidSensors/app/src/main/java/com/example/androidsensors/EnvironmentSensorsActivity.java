package com.example.androidsensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EnvironmentSensorsActivity extends AppCompatActivity {

    private static String HANDLE_REMOTE_DATA_FETCHING_TAG = "handleRemoteDataFetchingTag";

    RequestQueue requestQueue;

    SensorManager sensorManager;

    SensorEventListener sensorEventListener;

    Sensor ambientTemperatureSensor;
    Sensor lightSensor;
    Sensor ambientAirPressureSensor;
    Sensor ambientRelativeHumiditySensor;
    Sensor deviceTemperatureSensor;

    TextView ambientTemperatureTextView;
    TextView lightLevelTextView;
    TextView ambientAirPressureTextView;
    TextView ambientRelativeHumidityTextView;
    TextView deviceTemperatureTextView;
    TextView availableSensorsTextView;
    TextView dataTextView;

    Switch toggleAvailableSensorsSwitch;

    Button fetchChannelDataButton;

    private static final String THINGSPEAK_SENSORS_CH_01_FEED_URL = "https://api.thingspeak.com/channels/1578182/feeds.json?api_key=S4B2D2E4B500QURF&results=4";
    private static final String THINGSPEAK_SENSORS_CH_01_FIELD_URL = "https://api.thingspeak.com/channels/1578182/fields/1.json?api_key=S4B2D2E4B500QURF&results=2";

    Map<Integer, TextView> sensorTypeToWidget = new HashMap<Integer, TextView>();

    private void initActivity() {
        requestQueue = Volley.newRequestQueue(this);
    }

    private void initWidgets() {
        setContentView(R.layout.activity_environment_sensors);

        // Get references to the `TextView` widgets
        ambientTemperatureTextView = findViewById(R.id.ambientTempTextView);
        lightLevelTextView = findViewById(R.id.lightLevelTextView);
        ambientAirPressureTextView = findViewById(R.id.ambientAirPressureTextView);
        ambientRelativeHumidityTextView = findViewById(R.id.ambientRelaviteHumidityTextView);
        deviceTemperatureTextView = findViewById(R.id.deviceTempTextView);
        availableSensorsTextView = findViewById(R.id.availableSensorsTextView);
        dataTextView = findViewById(R.id.dataTextView);

        // Connect the sensor types to their matching `TextView` widgets
        sensorTypeToWidget.put(Sensor.TYPE_AMBIENT_TEMPERATURE, ambientTemperatureTextView);
        sensorTypeToWidget.put(Sensor.TYPE_LIGHT, lightLevelTextView);
        sensorTypeToWidget.put(Sensor.TYPE_PRESSURE, ambientAirPressureTextView);
        sensorTypeToWidget.put(Sensor.TYPE_RELATIVE_HUMIDITY, ambientRelativeHumidityTextView);
        sensorTypeToWidget.put(Sensor.TYPE_TEMPERATURE, deviceTemperatureTextView);

        // Get refs. to the `Switch` widgets
        toggleAvailableSensorsSwitch = findViewById(R.id.toggleExistingSensorsSwitch);
        toggleAvailableSensorsSwitch.setTag(R.id.visibility_switch_destination_widget, availableSensorsTextView);

        // Get refs. to the `Button` widgets
        fetchChannelDataButton = findViewById(R.id.fetchChannelDataButton);
    }

    private void initSensors() {

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Iterator<Sensor> iterator = sensorManager.getSensorList(Sensor.TYPE_ALL).iterator();
        String sensorsNames = "";
        while (iterator.hasNext()) {
            sensorsNames += String.format("%s, ", iterator.next().getName());
        }

        availableSensorsTextView.setText(sensorsNames);

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Sensor sensor = sensorEvent.sensor;
                double sensorOutput = sensorEvent.values[0];
                switch (sensor.getType()) {
                    case Sensor.TYPE_AMBIENT_TEMPERATURE:
                        ambientTemperatureTextView.setText(String.format("%s", sensorOutput));
                        break;
                    case Sensor.TYPE_LIGHT:
                        lightLevelTextView.setText(String.format("%s", sensorOutput));
                        break;
                    case Sensor.TYPE_PRESSURE:
                        ambientAirPressureTextView.setText(String.format("%s", sensorOutput));
                        break;
                    case Sensor.TYPE_RELATIVE_HUMIDITY:
                        ambientRelativeHumidityTextView.setText(String.format("%s", sensorOutput));
                        break;
                    case Sensor.TYPE_TEMPERATURE:
                        deviceTemperatureTextView.setText(String.format("%s", sensorOutput));
                        break;
                    default:
                        break;
                }
//                TextView textView = sensorTypeToWidget.get(sensor.getType());
//                textView.setText(String.format("%s", sensorOutput));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
                // Do something here if sensor accuracy changes.
            }
        };

        registerListeners();
    }

    // todo: refactor this method
    private void registerListeners() {
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE), SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE), SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY), SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE), SensorManager.SENSOR_DELAY_UI);
    }

    /** This method gets the data from the `ThingSpeak` site and channel and present them on the app's screen
     * @implNote we use <a href="https://www.tutorialspoint.com/how-to-use-volley-string-request-in-android">this</a> somewhat relevant post
     * and also <a href="https://youtu.be/W2HkekSG_Oo">this</a> youtube tutorial
     */
    private void handleRemoteDataFetching() {
        // Obtain ref. to the ProgressBar
        final ProgressBar progressBar = findViewById(R.id.fetchDataProgressBar);

        // Update the relevant widgets
        progressBar.setVisibility(View.VISIBLE);
        dataTextView.setText("");

        // Creating a StringRequest to send request to the url
        StringRequest stringRequest = new StringRequest(Method.GET,
                THINGSPEAK_SENSORS_CH_01_FEED_URL, new Response.Listener<String> () {
            @Override
            public void onResponse(String response) {
                // hiding the ProgressBar after completion
                progressBar.setVisibility(View.INVISIBLE);
                StringBuilder stringBuilder = new StringBuilder("Feeds data:\n");

                try {
                    // Convert the response string into a JSON object
                    JSONObject resObj = new JSONObject(response);
                    JSONObject channel = resObj.getJSONObject("channel");
                    JSONArray feeds = resObj.getJSONArray("feeds");

                    // Print a simple representation of the fields data
                    for (int i = 0; i < feeds.length(); i++) {
                        stringBuilder.append(String.format("%s\n", feeds.getJSONObject(i).toString()));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                dataTextView.setText(stringBuilder.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivity();
        initWidgets();
        initSensors();
        handleRemoteDataFetching();
    }

    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
        registerListeners();
    }

    @Override
    protected void onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }

    public void onClick_toggleVisibility(View view) {
        // Get the widget that we wish to toggle visibility for
        final View togglledView = (View) view.getTag(R.id.visibility_switch_destination_widget);
        int viewVisibility = togglledView.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE;
        togglledView.setVisibility(viewVisibility);
    }

    public void onClick_fetchChannelData(View view) {
        handleRemoteDataFetching();
    }
}