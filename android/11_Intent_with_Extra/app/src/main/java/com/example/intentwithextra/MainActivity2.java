package com.example.intentwithextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.intentwithextra.data.UserData;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    EditText responseEditText;
    Button navBackScreenButton;
    TextView prevScreenUserInputTextView;
    TextView userDataTextView;

    /* Initialize widget fields in this activity. */
    private void initWidgets() {
        responseEditText = findViewById(R.id.responseET);
        navBackScreenButton = findViewById(R.id.navBackScreenBtn);
        prevScreenUserInputTextView = findViewById(R.id.prevScreenInputTV);
        userDataTextView = findViewById(R.id.userDataTV);
    }

    /* This method initializes local variables with data by calling the `getStringExtra` method
     */
    private void initData() {
        Intent prevScreenIntent = getIntent();
        String userInput = prevScreenIntent.getStringExtra(getString(R.string.user_input));
        String userDataStr = (String) prevScreenIntent.getSerializableExtra(getString(R.string.user_data));

        prevScreenUserInputTextView.setText(userInput);

        String[] parsedUserData = userDataStr.split(",");
        UserData userData = new UserData(parsedUserData[0], parsedUserData[1], new Boolean(parsedUserData[2]));
        userDataTextView.setText(userData.printNice());
    }

    private void initWidgetsHandlers() {
        navBackScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                String responseMsg = responseEditText.getText().toString();

                intent.putExtra(getString(R.string.response_message), responseMsg);
                setResult(999, intent);
                finish();// Finish (clear) this activity from the activities stack.
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initWidgets();
        initData();
        initWidgetsHandlers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu with items
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }
}