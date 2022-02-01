package com.example.progressdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView statusTextView;
    Button spinnerDialogButton;
    Button progressDialogButton;

    private boolean abort = false;

    private void initWidgets() {
        setContentView(R.layout.activity_main);

        statusTextView = findViewById(R.id.statusTextView);
        spinnerDialogButton = findViewById(R.id.openSpinnerDialogButton);
        progressDialogButton = findViewById(R.id.openProgressDialogButton);

        initWidgetsListeners();
        testConcurrentExecution();
    }

    /** Create 2 objects which would run concurrently and print data in the logcat alongside with this activity. */
    private void testConcurrentExecution() {
        Progress progress1 = new Progress(0, "progress1");
        Progress progress2 = new Progress(2, "progress2");
        progress1.run();
        progress2.start();
        Log.i(Progress.PROGRESS_TAG, "Printing from MainActivity");
    }

    private void initWidgetsListeners() {

        // Register an `onClick` listener to the `spinnerDialogButton` widget
        spinnerDialogButton.setOnClickListener(new View.OnClickListener() {

            // Only after the user clicked the button execute this `onClick` listener
            @Override
            public void onClick(View view) {

                // Define an Ad-Hoc `ProgressDialog` object each time the user clicks the relevant widget
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

                // Define the appearance and behavior of the dialog
                progressDialog.setTitle("Please wait");
                progressDialog.setMessage("Downloading files it may take a few minutes...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                /* Documentation for indeterminate mode can be found here
                https://developer.android.com/reference/android/app/ProgressDialog#setIndeterminate(boolean) */
                progressDialog.setIndeterminate(true);

                // Add a negative (cancel) button to this dialog
                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {

                    // The listener which runs if the user clicks the dialog's "negative" button
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Proccess cancelled", Toast.LENGTH_SHORT).show();
                    }
                });

                // Display the dialog
                progressDialog.show();

                /* The Runnable that will be executed. This value cannot be null. */
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                    }
                },10000);/*The delay (in milliseconds) until the Runnable will be executed.*/
            }
        });

        progressDialogButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                abort = false;

                // Define the appearance and behavior of the dialog
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("Please wait");
                progressDialog.setMessage("Download file, please be patient");
                progressDialog.setMax(300);// Default value is 100
                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {

                    // When the user clicks the negative button of the dialog, we change the value of `abort`
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        abort = true;
                    }
                });

                /* We present the dialog, note that even before the dialog appears on screen -
                    (and the user can actually see the `Cancel` button), the listener for that button
                    was defined. */
                progressDialog.show();

                /* A thread object is created and run while the value of `abort` is false,
                each time after execution it sleeps for 100 milliseconds. */
                new Thread() {

                    @Override
                    public void run() {
                        super.run();
                        while (!abort) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            progressDialog.incrementProgressBy(1);
                            if(progressDialog.getProgress() == progressDialog.getMax())
                                abort = true;
                        }

                        progressDialog.dismiss();
                    }
                }.start();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgets();
    }
}