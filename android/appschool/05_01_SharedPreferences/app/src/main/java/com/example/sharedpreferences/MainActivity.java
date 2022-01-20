package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author APPSCHOOL
 *
 * @implNote this code could be found <a href="https://appschool.co.il/assets/moxifile/books/android/android5.pdf">here</a>.
 */
public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Button saveButton;
    EditText firstNameET, lastNameET;
    TextView greetingTV;

    private void initWidgets() {
        saveButton = findViewById(R.id.saveButton);
        firstNameET = findViewById(R.id.firstNameEditText);
        lastNameET = findViewById(R.id.lastNameEditText);
        greetingTV = findViewById(R.id.greetingTextView);
    }

    private void initWidgetsHandlers() {
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Create an editor for our shared prefs file
                SharedPreferences.Editor editor = sharedPreferences.edit();

                // Update our editor with the new values
                editor.putString(getString(R.string.firstName), firstNameET.getText().toString());
                editor.putString(getString(R.string.lastName), lastNameET.getText().toString());

                // Commit the edited KV (Key-Value) pairs in our editor
                editor.commit();
            }
        });
    }

    private void initData() {
        /* obtain the shared preferences for the `userDetails`,
            notice that appschool's code has hard-coded 0 instead of `MODE_PRIVATE`
            (which is considered a bad practice) */
        sharedPreferences = getSharedPreferences("userDetails", MODE_PRIVATE);

        String firstName = sharedPreferences.getString(getString(R.string.firstName), null);
        String lastName = sharedPreferences.getString(getString(R.string.lastName), null);

        if (firstName != null && lastName != null)
            greetingTV.setText(String.format("Welcome %s %s", firstName, lastName));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        initWidgetsHandlers();
        initData();
    }
}