package com.example.csv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private final String CSV_DATA = "csv_data_logging_tag";// Used for development

    private void initWidgets() {
        setContentView(R.layout.activity_main);
    }

    /** Prints to the `logcat` the contents of a csv file.
     * @implNote
     * <ul>
     *     <li>The logged csv file is located in the `res/raw` folder.</li>
     *     <li>We use the {@link com.opencsv} library to read (and parse) the csv file.</li>
     * </ul> */
    private void loadAndPrintCSVData() {

        // We use `InputStream` to represent (an input stream of) bytes.
        final InputStream inputStream = getResources().openRawResource(R.raw.data);

        // We use `CSVReader` to conveniently parse csv data (i.e. multiple values into String[]).
        final CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));

        try {
            String[] parsedLine = csvReader.readNext();

            while (parsedLine != null) {
                Log.i(CSV_DATA, String.format("Parsed line: %s", Arrays.toString(parsedLine)));

                parsedLine = csvReader.readNext();
            }
        } catch (IOException | CsvValidationException exception) {
            Toast.makeText(this,"Encountered an exception (read log for details).", Toast.LENGTH_LONG)
                .show();
            exception.printStackTrace();
        }
    }

    /** Same as in method {@link #loadAndPrintCSVData()} only without any library and handling the
     * csv data as-is (simple string). */
    private void loadAndPrintStreamedData() {
        final InputStream inputStream = getResources().openRawResource(R.raw.data);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String line = bufferedReader.readLine();

            while (line != null) {
                Log.i(CSV_DATA, String.format("Line: %s", line));

                line = bufferedReader.readLine();
            }
        } catch (IOException ioException) {
            Toast.makeText(this,"Encountered an exception (read log for details).", Toast.LENGTH_LONG)
                    .show();
            ioException.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgets();
        loadAndPrintCSVData();
        loadAndPrintStreamedData();
    }
}