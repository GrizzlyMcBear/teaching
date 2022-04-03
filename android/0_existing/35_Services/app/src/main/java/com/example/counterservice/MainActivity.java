package com.example.counterservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
	
	Button startServiceButton;
	Button stopServiceButton;
	Intent intent;
	
	private void initData() {
		intent = new Intent(this, CounterService.class);
		intent.putExtra("counter",10);
		intent.putExtra("kill_self",true);
	}
	
	private void initWidgets() {
		setContentView(R.layout.activity_main);
		startServiceButton = findViewById(R.id.start_btn);
		stopServiceButton = findViewById(R.id.stop_btn);
	}
	
	private void initWidgetsHandlers() {
		startServiceButton.setOnClickListener(new View.OnClickListener() {
			/**
			 * Calling this method would cause the system to enter the
			 * {@link android.app.Service#onStartCommand(Intent, int, int)} method.
			 */
			@Override
			public void onClick(View view) {
				startService(intent);
			}
		});
		stopServiceButton.setOnClickListener(new View.OnClickListener() {
			/**
			 * Calling this method would stop the service from running, another way to stop the service
			 * is for itself to call {@link Service#stopSelf()}.
			 */
			@Override
			public void onClick(View view) {
				stopService(intent);
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		initWidgets();
		initWidgetsHandlers();
	}
}