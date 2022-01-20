package com.example.datepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView timeTv;
    TextView dateTv;
    Button dateBtn;
    Button timeBtn;

    private void initWidgets() {
        setContentView(R.layout.activity_main);
        timeTv = findViewById(R.id.time_output);
        dateTv = findViewById(R.id.date_output);
        dateBtn = findViewById(R.id.date_btn);
        timeBtn = findViewById(R.id.time_btn);
        initWidgetsListeners();
    }

    private void initWidgetsListeners() {

        dateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Use the `java.util.Calendar` to obtain the current date
                Calendar calendar = Calendar.getInstance();
                int year  = calendar.get(Calendar.YEAR);
                int month  = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                /* We use the `DatePickerDialog` to  (which contains a {@link DatePicker}).
                 *
                 * Note: we could define a new variable (in case we wanted to use it elsewhere),
                 *  doing so would force us to separate between the initialization (assignment of c'tor value)
                 *  and calling the `show()` method.
                 *
                 * The c'tor which is being called is
                 * https://developer.android.com/reference/android/app/DatePickerDialog#DatePickerDialog(android.content.Context,%20android.app.DatePickerDialog.OnDateSetListener,%20int,%20int,%20int)
                 */
                new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        dateTv.setText(dayOfMonth + " / " + (month + 1) + " / " + year);
                    }

                }, year, month, day).show();
            }
        });
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Use the `java.util.Calendar` to obtain the current date
                Calendar calendar = Calendar.getInstance();
                int hour  = calendar.get(Calendar.HOUR_OF_DAY);
                int minutes = calendar.get(Calendar.MINUTE);
                //  Q: how can we get the seconds and milliseconds?
                /*  A: by using the constant values in `Calendar` */
                //  Q: are those values important for your android project?

                new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        timeTv.setText(hourOfDay + " : " + minute);
                    }
                }, hour, minutes, true).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgets();
    }
}