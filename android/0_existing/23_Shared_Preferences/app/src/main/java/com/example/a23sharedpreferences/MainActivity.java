package com.example.a23sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    // We wish to use a unique identification (tagging) to use in our data logging
    final String TAG = "23_SharedPreferences_MainActivity";

    SharedPreferences sharedPrefsA1;
    EditText usernameET;
    Button btn;

    private void initWidgets() {
        btn = findViewById(R.id.btn);
        usernameET = findViewById(R.id.username_input);

        /* The SP (shared preferences) file is like a dictionary,
            in which key-value pairs are stored in what we call a "sandbox".
            further (general) details could be found here:
            https://developer.android.com/training/data-storage/shared-preferences */

        // When we wish to use only 1 SP file in our activity
//        SharedPreferences sp = getPreferences();

        /* When we wish to use several SP files - we need to identify them by name
            further details can be found here:
            https://developer.android.com/training/data-storage/shared-preferences#GetSharedPreferences */
        /* If we wish to share preferences for this application only, we use `MODE_PRIVATE`
            Ahhh, but what are the other types? */
        sharedPrefsA1 = getSharedPreferences("details", Context.MODE_PRIVATE);
    }

    private void initData() {

        // If the key `not_first_run` doesn't exist the default returned value is `false`
        if (sharedPrefsA1.getBoolean("not_first_run", false)) {

            // Using the flag `not_first_run` we initialize the key `username` with the value "" (empty string)
            usernameET.setText(sharedPrefsA1.getString("username", ""));
        }
    }

    private void initWidgetsHandlers() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        initData();
        initWidgetsHandlers();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Create a "table" (dictionary/map) for the data
        SharedPreferences.Editor editor = sharedPrefsA1.edit();

        // Update values
        editor.putString("username", usernameET.getText().toString());
        editor.putBoolean("not_first_run", true);// Q: can we improve performance here?

        editor.commit();// This order write the data in the memory app.
        //editor.apply();// This command is like editor.commit(), only it writes the data when the cpu is ready

        // Go over `Logcat` for students
        Log.i(TAG, "onPause");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}