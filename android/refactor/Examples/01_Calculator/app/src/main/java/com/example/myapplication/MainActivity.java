package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/** Starter code for a calculator application. */
public class MainActivity extends AppCompatActivity {
	
	// Fields which refer to widgets - `View` components which are visible to the app's user.
	EditText num1EditText;
	EditText num2EditText;
	TextView resultTextView;
	Button plusButton;
	
	/** Initialize the widgets after connecting this class to its layout (xml) file. */
	private void initWidgets() {
		setContentView(R.layout.activity_main);
		
		num1EditText = findViewById(R.id.num1EditText);
		num2EditText = findViewById(R.id.num2EditText);
		resultTextView = findViewById(R.id.resultTextView);
		plusButton = findViewById(R.id.plusButton);
	}
	
	/** Set the event listeners for widgets. */
	private void initWidgetsListeners() {
		plusButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Read and parse the 1st number into an `int` variable
				final String num1AsStr = num1EditText.getText().toString();
				final int num1 = Integer.parseInt(num1AsStr);
				
				// Read and parse the 2nd number into an `int` variable
				final String num2AsStr = num2EditText.getText().toString();
				final int num2 = Integer.parseInt(num2AsStr);
				
				// Sum the two numbers
				int result = num1 + num2;
				
				// Update the result in the relevant `TextView` widget so the user could see it.
				resultTextView.setText(result + "");
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initWidgets();
		initWidgetsListeners();
	}
}