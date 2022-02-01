package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button dialog_btn1,dialog_btn2, btn2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog_btn1 = findViewById(R.id.dialogBtn);
        dialog_btn2 = findViewById(R.id.dialogBtn2);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("my first dialog");
        builder.setMessage("do you like the lesson?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"thank you for that",Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"so sad",Toast.LENGTH_SHORT).show();
            }
        });



        dialog_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        Dialog dialog2 = new Dialog(this);
        dialog2.setContentView(R.layout.dialog);
        btn2 = dialog2.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"we love yoga", Toast.LENGTH_SHORT).show();
            }
        });


        dialog_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog2.setCancelable(true);
                dialog2.show();
            }
        });

    }
}