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

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    TextView responseTextView;
    Button navScreenButton;
    EditText msgEditText;

    private void initWidgets() {
        responseTextView = findViewById(R.id.responseTV);
        navScreenButton = findViewById(R.id.navBackScreenBtn);
        msgEditText = findViewById(R.id.msgET);
    }

    private void initWidgetsHandlers() {
        navScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                UserData myData = new UserData("Ronen", "Cohen", true);

                // Adding the extra data
                intent.putExtra(getString(R.string.user_input),
                        msgEditText.getText().toString());
                intent.putExtra(getString(R.string.user_data),
                        myData.toString());
//                intent.putExtra(getString(R.string.user_data),
//                        myData);

                // Option 1
//                startActivity(intent);
                // Option 2
                startActivityForResult(intent, 2);// Activity is started with requestCode 2
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        initWidgetsHandlers();
    }

    // Callback method (remember what is a callback method)?
    // This method reads a message from another activity.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 2) {// In case `requestCode` is the same as check if the request code is same as what is passed  here it is 2
//            String message = data.getStringExtra(getString(R.string.response_message));
//            responseTextView.setText(message);
//        }
        responseTextView.setText(String.format("Request code: %s, Result code: %s", requestCode, resultCode));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}