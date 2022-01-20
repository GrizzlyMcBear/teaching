package com.example.dialogs;

import static android.widget.Toast.LENGTH_LONG;
import static androidx.appcompat.app.AlertDialog.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Builder builder = new Builder(this);
        builder.setTitle("Are you sure dialog title");
        builder.setMessage("Do you wish to continue message");

        builder.setIcon(R.drawable.ic_launcher_background);
        builder.setCancelable(false);

        builder.setPositiveButton("כן", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText( MainActivity.this, "You have chosen yes.", LENGTH_LONG).show();
            }
        }).setNegativeButton("לא", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText( MainActivity.this, "You have chosen no.", LENGTH_LONG).show();
            }
        }).create()
        .show();

        DialogInterface customDialog = new DialogInterface() {
            @Override
            public void cancel() {

            }

            @Override
            public void dismiss() {

            }
        };
        /*

        dialog.setContentView(R.layout.custom_dialog_share);
        dialog.setCancelable(false);

        Button bShare= dialog.findViewById(R.id.dShare);
        Button bDel= dialog.findViewById(R.id.dDel);

        dialog.show();
        */
    }
}