package com.example.simpleadapterexample1;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends ListActivity {

    ArrayList<Dog> dogs = new ArrayList<>();

    private void initWidgets() {
        setContentView(R.layout.activity_main);
    }

    private void initData() {
        loadDogsData();

        /* Connect data (`dogs`) with the layout (`R.layout.dog_cell`) in which each item would be presented
          and also the `TextView` which would get populated with the data of each item. */
        final ArrayAdapter<Dog> dogArrayAdapter = new ArrayAdapter<Dog>(this,
                R.layout.dog_cell, R.id.dogInfoTextView, dogs);

        setListAdapter(dogArrayAdapter);
    }

    /** Read and populate the dogs details from the csv file located at `res/raw/dogs.csv` */
    private void loadDogsData() {
        try {
            final InputStream inputStream = getResources().openRawResource(R.raw.dogs);
            final CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
            csvReader.readNext();
            String[] dog = csvReader.readNext();
            while (dog != null) {
                dogs.add(new Dog(Integer.parseInt(dog[0]), dog[1]));
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgets();
        initData();
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        Toast.makeText(this, dogs.get(position).toString(), Toast.LENGTH_SHORT).show();
    }
}