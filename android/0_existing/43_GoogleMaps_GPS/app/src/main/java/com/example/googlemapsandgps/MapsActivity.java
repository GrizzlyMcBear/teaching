package com.example.googlemapsandgps;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapsandgps.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.List;

/**
 * This activity is part of an application which presents the topic of Google Maps.
 * @implNote Here are several important notes to go over:
 * <ol>
 *     <li>This class implements the {@link OnMapReadyCallback} interface.</li>
 * </ol>
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {
	
	private GoogleMap mMap;
	private ActivityMapsBinding binding;
	private final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
	private static final String KEY_CAMERA_POSITION = "camera_position";
	private static final String KEY_LOCATION = "location";
	private final float DEFAULT_ZOOM = 13;
	private LatLng specialLocation;
	private CameraPosition cameraPosition;
	
	TextView textView;
	EditText editText;
	EditText editText1;
	EditText editText2;
	Button button1;
	String titleString;
	String snippetString;
	CheckBox checkBox;
	boolean deleteMode = false;
	boolean locationPermissionGranted = false;
	private FusedLocationProviderClient fusedLocationProviderClient;
	private Location lastKnownLocation;
	
	private boolean checkPermissions() {
		return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
				ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED;
	}
	private void requestPermissions() {
		ActivityCompat.requestPermissions(this,
				new String[] { Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
				PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
	}
	
	@SuppressLint("MissingPermission")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		binding = ActivityMapsBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		
		// Obtain the SupportMapFragment and get notified when the map is ready to be used.
		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);	// Connect to the map (resource) fragment.
		mapFragment.getMapAsync(this);	// Listener for when the map resource is ready to be used.
		
		requestPermissions();
		
		LocationManager lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		if (checkPermissions()) {
			// TODO: Consider calling ActivityCompat#requestPermissions (if it would assist the lesson).
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#requestPermissions for more details.
			return;
		}
		
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1000, this);
		
		// Construct a FusedLocationProviderClient.
		fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
		
		lastKnownLocation = savedInstanceState.getParcelable(KEY_LOCATION);
		cameraPosition = savedInstanceState.getParcelable(KEY_CAMERA_POSITION);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		if (mMap != null) {
			outState.putParcelable(KEY_CAMERA_POSITION, mMap.getCameraPosition());
			outState.putParcelable(KEY_LOCATION, lastKnownLocation);
		}
		super.onSaveInstanceState(outState);
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode,
										   @NonNull String[] permissions,
										   @NonNull int[] grantResults) {
		locationPermissionGranted = false;
		if (requestCode ==
				PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION) {// If request is cancelled, the result arrays are empty.
			if (grantResults.length > 0
					&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				locationPermissionGranted = true;
			}
		} else {
			super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		}
//		updateLocationUI();
	}
	
	/**
	 * Create the dialog to add a point of interest.
	 * @param latLng
	 */
	public void dialogCreator(LatLng latLng) {
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.dialog);
		dialog.setCancelable(true);
		
		editText1 = dialog.findViewById(R.id.title);
		editText2 = dialog.findViewById(R.id.snippet);
		button1 = dialog.findViewById(R.id.btn1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				titleString = editText1.getText().toString();
				snippetString = editText2.getText().toString();
				Marker marker = mMap.addMarker(new MarkerOptions()
						.position(latLng)
						.title(titleString)
						.snippet(snippetString));
				dialog.dismiss();
			}
		});
		dialog.show();
	}
	
	/**
	 * Manipulates the map once available.
	 * This callback is triggered when the map is ready to be used.
	 * This is where we can add markers or lines, add listeners or move the camera. In this case,
	 * we just add a marker for a special location.
	 * If Google Play services is not installed on the device, the user will be prompted to install
	 * it inside the SupportMapFragment. This method will only be triggered once the user has
	 * installed Google Play services and returned to the app.
	 */
	@Override
	public void onMapReady(GoogleMap googleMap) {
		mMap = googleMap;
		textView = findViewById(R.id.text);
		editText = findViewById(R.id.marker_name);
		checkBox = findViewById(R.id.btn);
		checkBox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				deleteMode = !deleteMode;
			}
		});
		
		// Add a marker in Sydney and move the camera
		specialLocation = new LatLng(32.9036454, 35.2322266);
		mMap.addMarker(new MarkerOptions().position(specialLocation).title("Marker @ special location"));
		mMap.moveCamera(CameraUpdateFactory.newLatLng(specialLocation));
		
		mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
			@Override
			public void onMapClick(@NonNull LatLng latLng) {
				dialogCreator(latLng);
			}
		});
		
		mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
			@Override
			public boolean onMarkerClick(Marker marker) {
				if (deleteMode) marker.remove();
				else marker.showInfoWindow();
				
				return true;
			}
		});
		
		// Get the current location of the device and set the position of the map.
		getDeviceLocation();
	}
	
	private void getDeviceLocation() {
		/*
		 * Get the best and most recent location of the device, which may be null in rare
		 * cases when a location is not available.
		 */
		try {
			if (locationPermissionGranted) {
				@SuppressLint("MissingPermission") Task<Location> locationResult = fusedLocationProviderClient.getLastLocation();
				locationResult.addOnCompleteListener(this, new OnCompleteListener<Location>() {
					@Override
					public void onComplete(@NonNull Task<Location> task) {
						if (task.isSuccessful()) {
							// Set the map's camera position to the current location of the device.
							lastKnownLocation = task.getResult();
							if (lastKnownLocation != null) {
								mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
										new LatLng(lastKnownLocation.getLatitude(),
												lastKnownLocation.getLongitude()), DEFAULT_ZOOM));
							}
						} else {
							Log.d("MapsActivityTag", "Current location is null. Using defaults.");
							Log.e("MapsActivityTag", "Exception: %s", task.getException());
							mMap.moveCamera(CameraUpdateFactory
									.newLatLngZoom(specialLocation, DEFAULT_ZOOM));
							mMap.getUiSettings().setMyLocationButtonEnabled(false);
						}
					}
				});
			}
		} catch (SecurityException e)  {
			Log.e("Exception: %s", e.getMessage(), e);
		}
	}
	
	@Override
	public void onLocationChanged(@NonNull Location location) {
		if (location != null) {
			LatLng myLocation = new LatLng(location.getLatitude(), location.getLongitude());
			//  mMap.addMarker(new MarkerOptions().position(myLocation).title("my location"));
			mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
		}
	}
	
	@Override
	public void onLocationChanged(@NonNull List<Location> locations) {
	}
	
	@Override
	public void onFlushComplete(int requestCode) {
	}
	
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
	}
	
	@Override
	public void onProviderEnabled(@NonNull String provider) {
	}
	
	@Override
	public void onProviderDisabled(@NonNull String provider) {
	}
	
	@Override
	public void onPointerCaptureChanged(boolean hasCapture) {
	}
}