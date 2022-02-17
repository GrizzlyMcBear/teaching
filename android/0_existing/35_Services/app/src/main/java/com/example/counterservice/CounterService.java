package com.example.counterservice;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * @author Ronen Cohen
 * @implNote This app is an example for the `Service`:
 * 	<ul>
 * 	    <li>A service overview could be found <a href="https://developer.android.com/guide/components/services">here</a>.</li>
 * 	    <li>There are 3 types of services:</br>
 * 	    	<ol>
 * 	    		<li><b>Foreground:</b> some of its operations are noticeable by the user,
 * 	    		the service must display a notification for the user.</li>
 * 	    		<li><b>Background:</b> perform operations which aren't noticeable by the user.</li>
 * 	    		<li><b>Bound:</b> acts as a `server` for (application) components which bind to it.
 * 	    		It lives as long as at least one component is bound to it (using {@link Service#bindService(Intent, ServiceConnection, int)}).</li>
 * 	    	</ol>
 * 	    </li>
 * 	</ul>
 */
public class CounterService extends Service {
	
	String TAG = "ServiceExampleLoggerTag";
	int counter;
	
	public static void startCounting(int limit, String tag) {
		for (int i = 0; i < limit; i++) {
			Log.d(tag, String.format("Thread counter: %d", i + 1));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Although we must implement this method, if we don't wish other components binding to this
	 * service - we'll return null.
	 * The system would call this method each time a component calls the `bindService()` and before
	 * this service starts running.
	 */
	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "Inside `onBind()`");
		return null;
	}
	
	/**
	 * The system calls this method once (for setup) and before all other methods (onBind, onStartCommand).
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(TAG,"Inside `onCreate()`");
	}
	
	/**
	 * The system would call this method each time before the service would start running.
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG,"Inside `onStartCommand()`");
		
		counter = intent.getIntExtra("counter",10);
		//startCounting(counter, TAG);
		new CounterThread(counter).start();
		
		return super.onStartCommand(intent, flags, startId);
	}
	
	private class CounterThread extends Thread {
		private int counter;
		
		public CounterThread(int counter) {
			this.counter = counter;
		}
		
		/**
		 * Let's try and count while this `CounterThread` is running.
		 */
		@Override
		public void run() {
			super.run();
			startCounting(counter, TAG);
			stopSelf();
		}
	}
	
	/**
	 * The system calls this method before killing the service, we should clean any used resources
	 * inside this method.
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG,"Inside `onDestroy()`");
	}
}