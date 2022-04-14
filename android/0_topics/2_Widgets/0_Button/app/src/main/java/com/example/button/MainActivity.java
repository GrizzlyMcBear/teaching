package com.example.button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author Ronen Cohen
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	/* todo: refactor this comment into the application
		These are fields in the `MainActivity` class,
        we use each one of them to control a different widget (View object) presented in our application. */
		
	/**
	 * The fields which refer 2 button widgets in the layout.
	 * @implNote We define fields (properties) referring the button widgets,
	 * allowing us to respond to user's actions and pass data in this activity's screen:
	 * <ul>
	 *     <li>A 'widget' is the UI component presented to the user.</li>
	 *     <li>The widgets would be placed in the matching layout file (activity_main.xml).</li>
	 * </ul>
	 */
	Button anonymousObjectButton;
	Button implementInterfaceButton;

	// todo: add documentation regarding method `findViewById` and connecting the widgets to the matching fields for this method (`initLayout`).
	private void initLayout() {
		setContentView(R.layout.activity_main);
		
		anonymousObjectButton = findViewById(R.id.anonymousObjectButton);
		implementInterfaceButton = findViewById(R.id.implementInterfaceButton);
	}
	/**
	 * Calling this method would attach listeners to widgets in the layout,
	 * using the fields referring them.
	 * @implNote While this method only sets ("connects") a widget to the desired method,
	 * the method would only be executed <u>when that specific event occurred</u>.
	 * i.e. only after we set a {@link View#setOnClickListener(View.OnClickListener)} to the
	 * `anonymousObjectButton` widget/field the following {@link #onClick(View)} method <u>could</u>
	 * get called. It <u>would</u> get called however only after the user clicked that button.
	 */
	private void initWidgetsListeners() {
		implementInterfaceButton.setOnClickListener(this);
		anonymousObjectButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String message = "You've clicked the `Anonymous` button.";
				Toast.makeText(v.getContext(), message, Toast.LENGTH_LONG).show();
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initLayout();
		initWidgetsListeners();
	}
	
	/**
	 * This method would get called each time a user would click a widget we've registered a listener
	 * to its {@link View#setOnClickListener(View.OnClickListener)}.
	 * @param view The object representing the widget which was clicked.
	 */
	@Override
	public void onClick(View view) {
		String message = "Hold on!!!!! What are you doing for god sake?!";
		
		if (view == implementInterfaceButton) {
			message = "You've clicked the `Interface` button.";
		}
		
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}
	
	//todo: continue refactoring this app from here.
	public void attributeOnClick(View v) {
		String message = "You've clicked the `Attribute` button.";
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
		
		// Create the text message with a string.
		String textMessage = "This is my text message.";
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
		sendIntent.setType("text/plain");
		
		// Try to invoke the intent.
		try {
			startActivity(sendIntent);
		} catch (ActivityNotFoundException e) {
			// Define what your app should do if no activity can handle the intent.
		}
	}
}