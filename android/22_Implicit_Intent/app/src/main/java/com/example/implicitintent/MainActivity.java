package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button browseBtn, callBtn, mapNavBtn, contactsBtn, wazeNavBtn,
            whatsappBtn, sendMsgBtn;
    EditText emailAddressET, websiteUrlET, phoneNumberET, latET, lonET,
            wazeLatET, wazeLonET, whatsappMassageET, whatsappNumberET;

    private void initWidgets() {
        sendMsgBtn = findViewById(R.id.sendMsgBtn);
        emailAddressET = findViewById(R.id.sendMsgET);
        websiteUrlET = findViewById(R.id.browseAddressET);
        phoneNumberET = findViewById(R.id.dialET);
        latET = findViewById(R.id.latitudeET);
        lonET = findViewById(R.id.longitudeET);
        browseBtn = findViewById(R.id.browseBtn);
        callBtn = findViewById(R.id.dialBtn);
        mapNavBtn = findViewById(R.id.mapNavBtn);
        contactsBtn = findViewById(R.id.showContactsBtn);

        wazeLatET = findViewById(R.id.wazeLatitudeET);
        wazeLonET = findViewById(R.id.wazeLongitudeET);
        whatsappMassageET = findViewById(R.id.whatsappMsgET);
        whatsappNumberET = findViewById(R.id.whatsappNumberET);
        wazeNavBtn = findViewById(R.id.wazeNavBtn);
        whatsappBtn = findViewById(R.id.whatsappBtn);
    }

    private void initWidgetsHandlers() {

        // Send Email, SMS etc.
        sendMsgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtain the email addresses as entered by the user (here emails are seperated by a comma `,`)
                String[] addresses = emailAddressET.getText().toString().split("[,]");

                // Create a new implicit intent which sends data
                Intent intent = new Intent(Intent.ACTION_SEND);

                // Add extra data relevant for me (as the sender) and for the email app/activity
                intent.putExtra(Intent.EXTRA_TEXT, "this is the email body...");
                intent.putExtra(Intent.EXTRA_SUBJECT, "this is the email subject...");
                intent.putExtra(Intent.EXTRA_EMAIL, addresses);

                // Define the type of data passed in this intent as `text/plain`
                intent.setType("text/plain");

                // In case we wish to send email without any customization
                //  startActivity(intent);

                // In case we wish to add a title to the application selection popup
                startActivity(Intent.createChooser(intent,"Send eMail using: "));
            }
        });

        // Website
        browseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String site = websiteUrlET.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + site));
                startActivity(intent);
            }
        });

        // Dial
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = phoneNumberET.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });

        // Map
        mapNavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lat = latET.getText().toString();
                String lon = lonET.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + lat + ","+ lon));
                startActivity(intent);
            }
        });

        // Show contacts
        contactsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
                startActivity(intent);
            }
        });

        // Waze
        wazeNavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String lat =  wazeLatET.getText().toString();
                    String lon =  wazeLonET.getText().toString();

                    // Launch Waze to look for Hawaii:
                    //  String url = "https://waze.com/ul?q=Hawaii"; // Option 1
                    //  String url = "https://waze.com/ul?q=66%20Acacia%20Avenue&ll=32.833219,34.977286&navigate=yes"; // Option 2
                    String url = "https://waze.com/ul?q=66%20Acacia%20Avenue&ll="+lon+","+lat+"&navigate=yes"; // Option 3

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse( url ) );
                    startActivity( intent );
                } catch (ActivityNotFoundException ex) {
                    // If Waze is not installed, open it in Google Play:
                    Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "market://details?id=com.waze" ) );
                    startActivity(intent);
                }
            }
        });

        // Whatsapp
        whatsappBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = whatsappNumberET.getText().toString();
                String messege = whatsappMassageET.getText().toString();

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, messege);
                sendIntent.putExtra("jid", number+"@s.whatsapp.net");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
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
}