package com.example.grilledcheesetoast;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button sendBtn;
    EditText firstName;
    EditText lastName;
    TextView response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Note: type conversion isn't required since SDK 28 */
        sendBtn = findViewById(R.id.sendButton);
        firstName = findViewById(R.id.firstNameEditText);
        lastName = findViewById(R.id.lastNameEditText);
        response = findViewById(R.id.responseTextView);
        firstName.setOnClickListener(this);
        lastName.setOnClickListener(this);
        sendBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v== sendBtn){
            if(firstName.getText().toString().length()>0 && lastName.getText().toString().length()>0)
            {
                response.setText(firstName.getText().toString() + "\n\n" + lastName.getText().toString());
                firstName.setText("");
                lastName.setText("");
            }
            else {
                Toast.makeText(this, "Please fill all the fields", LENGTH_SHORT).show();
            }
        }
    }
}