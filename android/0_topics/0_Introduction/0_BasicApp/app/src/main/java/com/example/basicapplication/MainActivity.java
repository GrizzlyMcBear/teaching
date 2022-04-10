package com.example.basicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
	
	/**
	 * @implNote Connect the local fields to the layout's widgets.
	 */
	private void initLayout() {
		setContentView(R.layout.activity_main);
	}
	
	/**
	 * This method gets called when an instance of this class is being created and before showing
	 * the resulting "screen" to the user.
	 * @param savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);// Call this class's super 'onCreate' method.
		initLayout();
	}
}