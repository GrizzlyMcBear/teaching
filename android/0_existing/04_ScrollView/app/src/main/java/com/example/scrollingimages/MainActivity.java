package com.example.scrollingimages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /** Initialize the widgets in this application.
     * @implNote Each widget is a visible component in our app which matches a {@link android.view.View},
     * Therefore the user of our app can either see or interact with it.
     */
    private void initWidgets() {
        /** Connect this context (the object representing this {@link android.app.Activity})
         * with its layout (xml file). */
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgets();
    }
}