package com.example.a01_button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /* Define fields (variables) to link from this activity's code to the actual views (widgets)
        as defined in the layout `activity_main.xml`. */
    Button anonymousButton, interfaceButton;

    /**
     * @implNote Connect the variables to the widgets and components in the activity.
     */
    private void initWidgets() {
        anonymousButton = findViewById(R.id.anonymousButton);
        interfaceButton = findViewById(R.id.interfaceButton);
    }

    /**
     * @implNote Set the event listeners for the button widgets in this activity.
     *
     * once these commands are executed - every time those buttons are pressed
     * Android would call the overridden method `onClick`
     * (due to us implementing the `View.OnClickListener` interface).
     */
    private void initWidgetsHandlers() {
        interfaceButton.setOnClickListener(this);
        anonymousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You've clicked the `Anonymous` button.", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    /* This method would get called during the creation of the screen
        (an object of type `MainActivity`). */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);// Call this activity's super
        setContentView(R.layout.activity_main);

        initWidgets();
        initWidgetsHandlers();
    }

    /* This method would get called every time one of the buttons above would be clicked,
    * its argument is the view object. */
    @Override
    public void onClick(View v) {
        if (v == interfaceButton) {
            Toast.makeText(this, "You've clicked the `Interface` button.", Toast.LENGTH_LONG)
                    .show();
        } else {
            Toast.makeText(this, "Hold on!!!!! What are you doing for god sake?!", Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void attributeOnClick(View v) {
        Toast.makeText(this, "You've clicked the `Attribute` button.", Toast.LENGTH_LONG)
                .show();

        // Create the text message with a string.
        String textMessage = "This is my text message.";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
        sendIntent.setType("text/plain");

        // Try to invoke the intent.
        try {
            startActivity(sendIntent);
        } catch (ActivityNotFoundException e) {
            // Define what your app should do if no activity can handle the intent.
        }
    }

}