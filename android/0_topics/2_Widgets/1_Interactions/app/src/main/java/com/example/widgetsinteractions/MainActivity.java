package com.example.widgetsinteractions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Ronen Cohen
 * @implNote This application shows the interactions between several widgets.
 */
public class MainActivity extends AppCompatActivity {
	
	/* Usually defining several fields of the same type separated by commas is considered a bad-practice
	* as it probably mean we've done something wrong (by defining this much variables in the same location) */
	private EditText nameInput, phoneInput;
	private TextView nameDisplay, phoneDisplay;
	private Button updateName, updatePhone, updateAll;
	
	private void updateName() {
		// Read (get) the text entered by the user into a local (helper) variable.
		String name = nameInput.getText().toString();
		// Write (set) the previous text into the relevant (TextView) widget.
		nameDisplay.setText(name);
	}
	private void updatePhone() {
		String phone = phoneInput.getText().toString();
		phoneDisplay.setText(phone);
	}
	/**
	 * @implNote we might wish to write this method, considering our app's scale and content.
	 */
	private void updateAll() {
		updateName();
		updatePhone();
	}
	/**
	 * @implNote Several notes:</br>
	 * <ul>
	 *     <li>This method uses the {@link AppCompatActivity#setContentView(int)} method as we've
	 *     already seen.</li>
	 *     <li>We also use the {@link View#findViewById(int)} method to connect this class's fields
	 *     to widgets in the matching layout.</li>
	 * </ul>
	 */
	private void initLayout() {
		setContentView(R.layout.activity_main);
		
		// Input widgets
		nameInput = findViewById(R.id.usernameInput);
		phoneInput = findViewById(R.id.phoneInput);
		
		// Output widgets
		nameDisplay = findViewById(R.id.nameDisplay);
		phoneDisplay = findViewById(R.id.phoneDisplay);
		
		// Buttons
		updateName = findViewById(R.id.updateNameButton);
		updatePhone = findViewById(R.id.updatePhoneButton);
		updateAll = findViewById(R.id.updateAllButton);
	}
	private boolean isLayoutValid() {
		return (nameInput != null && phoneInput != null &&
				nameDisplay != null && phoneDisplay != null &&
				updateName != null && updatePhone != null && updateAll != null);
	}
	
	/**
	 * This method contains code which enables our buttons to "work".
	 * @implNote This is a (overview) of the chronological order of occurrences:
	 * <ol>
	 *     	<li>"Android" creates this activity's object (and calls `onCreate`).</li>
	 *     	<li>We tell "Android" to link a listener method to a button:
	 *     		<ul>
	 *     			<li>Which button? the one referenced by `updateBtn`.</li>
	 *     			<li>What method? convention requires the `onClick` method.</li>
	 *     		</ul>
	 *     	</li>
	 *     	<li>The user clicked the relevant button.</li>
	 *     	<li>"Android" calls the `onClick` method defined here.</li>
	 * </ol>
	 */
	private void initListeners() {
		updateName.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				updateName();
			}
		});
		updatePhone.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				updatePhone();
			}
		});
		updateAll.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				updateName();
				updatePhone();
//				updateAll();
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initLayout();
		if (isLayoutValid())
			initListeners();
	}
}