package com.example.whereismymind;

import static java.lang.String.format;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import whereismymind.R;

public class MainActivity extends AppCompatActivity implements LocationListener {
	
	final int LOCATION_PERMISSION_REQUEST = 1;
	
	Button locationUpdatesRegister;
	Button locationUpdatesRemove;
	
	/**
	 * The {@link LocationManager} helps us with:
	 * <ul>
	 *     <li>Retrieving the current location of the device (longitude and latitude).</li>
	 *     <li>Generates a notification when the device reaches a given proximity from a certain location.</li>
	 * </ul>
	 */
	LocationManager locationManager;
	TextView coordinates, address;
	
	/**
	 * The {@link Geocoder} helps us with data relating the geolocation:
	 * <ul>
	 *     <li><b>Geocoding: </b>getting the latitude and longitude of a given address.</li>
	 *     <li><b>Reverse Geocoding: </b>getting the addresses matching a given [lat, lon] location.</li>
	 * </ul>
	 */
	Geocoder geocoder;
	
	/**
	 * We update the app's UI using the {@link Handler}, due to inability to update it via a
	 * background thread.
	 * @implNote using {@link Handler} isn't the only way to do so.
	 */
	Handler handler = new Handler();
	
	private void initWidgets() {
		setContentView(R.layout.activity_main);
		
		coordinates = findViewById(R.id.current_coordinates);
		address = findViewById(R.id.current_address);
		
		locationUpdatesRegister = findViewById(R.id.location_updates_registration);
		locationUpdatesRemove = findViewById(R.id.location_updates_remove);
	}
	
	private void initLocationProviders() {
		geocoder = new Geocoder(this);
		
		// Question: what is the drawback of executing this code (called from `onCreate`)?
//		if(Build.VERSION.SDK_INT>=23) {
//			int hasLocationPermission = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);
//			if(hasLocationPermission!= PackageManager.PERMISSION_GRANTED) {
//				requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_PERMISSION_REQUEST);
//			}
//		}
		
		locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
	}
	
	private void initWidgetsHandlers() {
		locationUpdatesRegister.setOnClickListener(new View.OnClickListener() {
			/**
			 * Register to updates of the device's location, request for permission from the user
			 * if none exist.
			 * @param view
			 * @implNote Note the differentiation by the SDK (up to API 23 and above).
			 */
			@Override
			public void onClick(View view) {
				if (Build.VERSION.SDK_INT >= 23) {
					int hasLocationPermission = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);
					
					if (hasLocationPermission != PackageManager.PERMISSION_GRANTED) {
						String[] permissions = new String[]{ Manifest.permission.ACCESS_FINE_LOCATION };
						requestPermissions(permissions, LOCATION_PERMISSION_REQUEST);
					} else {
						locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,100,MainActivity.this);
					}
				} else {
					locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,100,MainActivity.this);
				}
			}
		});
		locationUpdatesRemove.setOnClickListener(new View.OnClickListener() {
			/**
			 * Remove the subscription from the location service.
			 * By doing so this app would stop getting updates about this device's location.
			 * @param view
			 */
			@Override
			public void onClick(View view) {
				locationManager.removeUpdates(MainActivity.this);
			}
		});
	}
	
	/**
	 * This method prints all of this phone's providers and logs them including whether they are
	 * enabled or not.
	 */
	private void logProviders() {
		List<String> providers = locationManager.getProviders(false);
		String message;
		
		for (String provider:providers) {
			message = format("%s enabled",
					locationManager.isProviderEnabled(provider) ? "is" : "isn't");
			
			Log.d(provider, message);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initWidgets();
		initLocationProviders();
		initWidgetsHandlers();
		
		logProviders();
		
		requestLocationProvider();
	}
	
	/**
	 * We generate a request criterion using a set of attributes, then ask the location manager for
	 * its location provider (which best complies with our request criteria).
	 */
	private void requestLocationProvider() {
		Criteria criteria = new Criteria();
		
		criteria.setSpeedRequired(false);
		criteria.setAltitudeRequired(false);
		criteria.setCostAllowed(true);
		criteria.setPowerRequirement(Criteria.POWER_HIGH);
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		
		String bestProvider = locationManager.getBestProvider(criteria,false);
		if (bestProvider != null)
			Log.d("best provider", bestProvider);
	}
	
	/**
	 * @param requestCode I might request different permissions, this is my way of differentiating between them.
	 * @param permissions
	 * @param grantResults I'm going to verify only the 1st result in this array.
	 */
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == LOCATION_PERMISSION_REQUEST) {
			if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
				// Notify the user on the issue and allow him to fix things.
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("Attention").setMessage("The application must have location permission in order for it to work!")
						.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
								intent.setData(Uri.parse("package:"+getPackageName()));
								startActivity(intent);
							}
						})
						.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								finish();
							}
						}).setCancelable(false).show();
			}
		}
	}
	
	@Override
	public void onLocationChanged(Location location) {
		final double latitude = location.getLatitude();
		final double longitude = location.getLongitude();
		
		coordinates.setText(format("%.5f , %.5f", latitude, longitude));
		
		new Thread() {
			@Override
			public void run() {
				super.run();
				
				try {
					/* Returns a collection of best-match addresses for the given location in a decreasing manner.
					* Notes:
					* 1. The results should be localized.
					* 2. Result is async (using network) DON'T CALL IN MAIN THREAD.
					* 3. No guarantee on availability or accuracy.
					*/
					List<Address> addresses = geocoder.getFromLocation(latitude, longitude,1);
					final Address bestAddress = addresses.get(0);
					
					handler.post(new Runnable() {
						@Override
						public void run() {
							String updatedText = format("%s, %s, %s, %s, %s, %s, %s",
									bestAddress.getCountryName(),
									bestAddress.getFeatureName(),	/* Returns the name of the location, if any ("Louvre", for the museum)*/
									bestAddress.getThoroughfare(),	/* Returns the street and building number*/
									bestAddress.getSubThoroughfare(),
									bestAddress.getAdminArea(),		/* Returns the state acronym ("CA", for California)*/
									bestAddress.getLocality(),		/* Returns the city name ("London")*/
									bestAddress.getSubLocality());
							
							address.setText(updatedText);
						}
					});
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	@Override
	public void onStatusChanged(String s, int i, Bundle bundle) {
	}
	
	@Override
	public void onProviderEnabled(String s) {
	}
	
	@Override
	public void onProviderDisabled(String s) {
	}
}