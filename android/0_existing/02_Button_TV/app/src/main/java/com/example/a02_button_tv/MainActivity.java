package com.example.a02_button_tv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Ronen Cohen
 * @implNote Our application has only 1 screen and its logic is defined in an object of this class.
 */
public class MainActivity extends AppCompatActivity {

    /* These are fields in the `MainActivity` class,
        we use each one of them to control a different widget (View object) presented in our application. */
    Button updateBtn;
    TextView updatedTV;
    EditText userInput;

    /**
     * @implNote This helper method links the widgets on the screen (as defined in the `activity_main.xml`)
     * to the fields defined in this class.<br/>
     * It uses the {@link #findViewById(int)} method with the relevant (and unique) IDs for each widget
     * to do so.
     */
    private void initWidgets() {
        updateBtn = findViewById(R.id.updateButton);
        updatedTV = findViewById(R.id.presentedTextView);
        userInput = findViewById(R.id.userInputEditText);
    }

    /**
     * @implNote This method gets called before this "screen" is first presented to the user of this app,
     * it gets called during a process in which an object of this class gets created -
     * much like the c'tor we learned of and use.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();

        /* Define the listener for user clicking on the button linked by the `updateBtn` variable.

            Note: this is a chronological order of code execution:
            1.1. "Android" creates this activity's object (and calls `onCreate`).
            1.2. We tell "Android" to link a listener method to a button
                    * Which button? the one referenced by `updateBtn`.
                    * What method? convention requires the `onClick` method.

            2.1. The user clicked the relevant button.
            2.2. "Android" calls the `onClick` method defined here.
         */
        updateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Read (get) the text entered by the user into a local (helper) variable.
                String userInputStr = userInput.getText().toString();

                // Write (set) the previous text into the TextView widget linked by the `updatedTV` variable.
                updatedTV.setText(userInputStr);
            }
        });
    }
}