package com.example.extendingaservice.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * This is an example for extending the {@link Service} class, this code and further information
 * can be found <a href="https://developer.android.com/guide/components/services#LifecycleCallbacks">here</a>.
 */
public class ExampleService extends Service {
	
	int startMode;       // indicates how to behave if the service is killed
	
	IBinder binder;      // interface for clients that bind
	
	boolean allowRebind; // indicates whether onRebind should be used
	
	public ExampleService() {
	}
	
	@Override
	public void onCreate() {
		// The service is being created
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// The service is starting, due to a call to startService()
		return startMode;
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// A client is binding to the service with bindService()
		return binder;
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		// All clients have unbound with unbindService()
		return allowRebind;
	}
	
	@Override
	public void onRebind(Intent intent) {
		// A client is binding to the service with bindService(),
		// after onUnbind() has already been called
	}
	
	@Override
	public void onDestroy() {
		// The service is no longer used and is being destroyed
	}
}