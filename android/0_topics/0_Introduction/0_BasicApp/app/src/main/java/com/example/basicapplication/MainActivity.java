package com.example.basicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * @author Ronen Cohen
 */
public class MainActivity extends AppCompatActivity {
	
	/**
	 * @implNote Connect the instance of this activity (the "business logic")
	 *	to the matching layout or UI (User Interface).
	 */
	private void initLayout() {
		setContentView(R.layout.activity_main);
	}
	
	/**
	 * @implNote This method gets called when an instance of this class is being created
	 *	and before showing any resulting "application screen" to the user.
	 * @param savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);// Call this class's super 'onCreate' method.
		initLayout();
	}
}