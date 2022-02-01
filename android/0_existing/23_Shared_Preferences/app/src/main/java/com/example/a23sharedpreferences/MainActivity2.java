package com.example.a23sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    // We wish to use a unique identification (tagging) to use in our data logging
    final String TAG = "23_SharedPreferences_SecondActivity";

    TextView usernameTV;
    SharedPreferences sharedPrefsA2;

    private void initWidgets() {
        usernameTV = findViewById(R.id.username_Tv);
    }

    private void loadAndPresentData() {
        // Q: remember what `getSharedPreferences` do?
        /* The `getSharedPreferences` retrieves (or creates in case none exists) the preferences file
            "details" (in this case). Further documentation could be found at:
            https://developer.android.com/reference/android/content/ContextWrapper.html#getSharedPreferences(java.lang.String,%20int)
        */
        sharedPrefsA2 = getSharedPreferences("details", MODE_PRIVATE);

        // Q: what would happen if we haven't saved any value in `username` key
        /* Solution: pass a default value - "rona" */
        usernameTV.setText(sharedPrefsA2.getString("username","rona"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initWidgets();
        loadAndPresentData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }
}