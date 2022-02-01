package com.example.foregroundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * The main activity in the `ForegroundService` application.
 * @implNote Further information could be found in
 * <a href="https://developer.android.com/guide/components/services#CreatingAService">Services Overview</a></br>
 * and in its subsection
 * <a href="https://developer.android.com/guide/components/services#CreatingAService">Creating a started service</a>
 */
public class MainActivity extends AppCompatActivity {
	
	Button startServiceBtn;

	Button stopServiceBtn;

	Intent intent;
	
	private void initData() {
		intent = new Intent(this, ForegroundService.class);
	}
	
	private void initWidgets() {
		setContentView(R.layout.activity_main);
		startServiceBtn = findViewById(R.id.startServiceButton);
		stopServiceBtn = findViewById(R.id.stopServiceButton);
	}
	
	private void initWidgetsListeners() {
		startServiceBtn.setOnClickListener(new View.OnClickListener() {
			/**
			 * This method creates a "Started Service" from {@link ForegroundService}.
			 * @implNote Several notes:</br>
			 * <ul>
			 *     <li>
			 *         By calling the {@link android.app.Service#startService(Intent)} this component
			 *         "starts" another service (android would execute the service's
			 *         {@link android.app.Service#onStartCommand(Intent, int, int)} method).
			 *     </li>
			 *     <li>
			 *         The started service would be disconnected from this component when using this way.
			 *         This could result in this component being destroyed and the service would still keep running.
			 *         In order for the service to stop we should:
			 *         <ol>
			 *             <li>Another component would call {@link android.app.Service#stopService(Intent)}.</li>
			 *             <li>The service would call {@link Service#stopSelf()} once finished doing its job.</li>
			 *         </ol>
			 *     </li>
			 *     <li>
			 *         We can use the service to process data concurrently using the intent argument,</br>
			 *         <b>e.g.</b> Passing data to the service to be stored in a cloud DB, then after saving it
			 *         the service would call {@link Service#stopSelf()}.
			 *     </li>
			 *     <li>
			 *         Android runs the target service in the same process as this application is allocated,
			 *         if that service is heavy in using resources - it would result in the activity being slow.
			 *         In that case starting a new <i>Thread</i> is recommended.
			 *     </li>
			 * </ul>
			 * @param view
			 */
			@Override
			public void onClick(View view) {
				startService(intent);
			}
		});
		stopServiceBtn.setOnClickListener(new View.OnClickListener() {
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
		initWidgetsListeners();
	}
}