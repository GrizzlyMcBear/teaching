package com.example.foregroundservice;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ForegroundService extends Service {
	
	public ForegroundService() {
	}
	
	final int NOTIFY_ID = 1;
	final int NOTIFY_ID1 = 2;
	
	/**
	 * Not enabling other components to bind into this service.
	 * @param intent
	 * @return
	 */
	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		Notification.Builder builder = new Notification.Builder(this);
		builder.setSmallIcon(android.R.drawable.star_on).setContentTitle("Foreground service")
				.setContentText("long lasting operation");
		
		Notification.Builder builder1 = new Notification.Builder(this);
		builder1.setSmallIcon(android.R.drawable.star_on).setContentTitle("number 2")
				.setContentText("long lasting operation");
		
		startForeground(NOTIFY_ID,builder.build());
		
		startForeground(NOTIFY_ID1,builder1.build());
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				
				stopForeground(false);
			}
		},5000);
		
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "Inside onDestroy()", Toast.LENGTH_SHORT).show();
	}
}