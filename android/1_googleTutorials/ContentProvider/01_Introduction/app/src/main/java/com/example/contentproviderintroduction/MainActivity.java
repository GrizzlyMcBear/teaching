package com.example.contentproviderintroduction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;

/**
 * @implNote These notes are a summary of the following:</br>
 * 	<ul>
 *     <li>
 *         <a href="https://developer.android.com/guide/topics/providers/content-providers">
 *         Content providers tutorial</a>.
 *     </li>
 *     <li>
 *         <a href="https://developer.android.com/reference/android/content/ContentProvider">
 *         ContentProvider documentation</a>.
 *     </li>
 * 	</ul>
 * 	Some of the content provider's benefits are:
 * 	<ul>
 * 	    <li>
 * 	        We use the {@link android.content.ContentProvider} when we want to make certain data
 * 	        available for multiple applications. We do so by encapsulating that data then "providing"
 * 	        it to other applications via the {@link android.content.ContentResolver} interface,
 * 	        while defining data security mechanisms. If our data would only be used in one other app -
 * 	        there's no need for the ContentProvider.
 * 	    </li>
 * 	    <li>
 * 	        Primary methods in the ContentProvider needed to be implemented are:
 * 	        <ul>
 * 	            <li><b>{@link ContentProvider#onCreate()}</b>: This method should finish running during a
 * 	            short-duration because it's being called from the app's main thread.</li>
 * 	            <li><b>{@link ContentProvider#query(Uri, String[], Bundle, CancellationSignal)}</b>: </li>
 * 	            <li><b>{@link ContentProvider#getType(Uri)}</b>: </li>
 * 	            <li>
 * 	                CRUD methods like the following might be called from multiple threads at the same time,
 * 	            	for this reason they should be thread-safe:
 * 	            	<ul>
 * 	            		<li><b>{@link ContentProvider#insert(Uri, ContentValues)}</b>: </li>
 * 	            		<li><b>{@link ContentProvider#update(Uri, ContentValues, Bundle)}</b>: </li>
 * 	            		<li><b>{@link ContentProvider#delete(Uri, Bundle)}</b>: </li>
 * 	            	</ul>
 * 	            </li>
 * 	        </ul>
 * 	    </li>
 * 	    <li>External entities requesting data from our app's ContentProvider are oblivious to the
 * 	    manner with which we store it, e.g. local file-system, remote DB etc.</li>
 * 	</ul>
 */
public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
}