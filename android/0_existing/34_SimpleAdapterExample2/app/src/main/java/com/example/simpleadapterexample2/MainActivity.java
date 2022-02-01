package com.example.simpleadapterexample2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView countriesListView;
    List<Map<String,Object>> countriesData;

    // The structure of a country data.
    public String[] countryDataStructure;

    // The widget IDs in the country layout template (for creating the view which represents each country).
    public int[] destinationTemplateWidgets;

    private void initWidgets() {
        setContentView(R.layout.activity_main);
        countriesListView = findViewById(R.id.my_list);
    }

    /** Initialize the data for the countries, also create a new {@link ArrayList} to store that data. */
    //todo: refactor this method's code
    private void initData() {
        countryDataStructure = new String[] {
                getString(R.string.country_template_flag),
                getString(R.string.country_template_name),
                getString(R.string.country_template_is_good)
        };

        destinationTemplateWidgets = new int[] {
                R.id.countryFlagImageView,
                R.id.countryNameTextView,
                R.id.countryIsGoodCheckBox
        };

        countriesData = new ArrayList<>();

        HashMap<String,Object> china = new HashMap<>();
        china.put("flag",R.drawable.flag_china);
        china.put("name","china");
        china.put("is_good",true);
        countriesData.add(china);

        HashMap<String,Object> france = new HashMap<>();
        france.put("flag",R.drawable.flag_france);
        france.put("name","france");
        france.put("is_good",false);
        countriesData.add(france);

        HashMap<String,Object> greece = new HashMap<>();
        greece.put("flag",R.drawable.flag_greece);
        greece.put("name","greece");
        greece.put("is_good",true);
        countriesData.add(greece);

        HashMap<String,Object> israel = new HashMap<>();
        israel.put("flag",R.drawable.flag_israel);
        israel.put("name","israel");
        israel.put("is_good",true);
        countriesData.add(israel);

        HashMap<String,Object> italy = new HashMap<>();
        italy.put("flag",R.drawable.flag_italy);
        italy.put("name","italy");
        italy.put("is_good",false);
        countriesData.add(italy);

        HashMap<String,Object> romania = new HashMap<>();
        romania.put("flag",R.drawable.flag_romania);
        romania.put("name","romania");
        romania.put("is_good",false);
        countriesData.add(romania);

        HashMap<String,Object> russia = new HashMap<>();
        russia.put("flag",R.drawable.flag_russia);
        russia.put("name","russia");
        russia.put("is_good", true);
        countriesData.add(russia);

        HashMap<String,Object> cyprus = new HashMap<>();
        cyprus.put("flag",R.drawable.flag_cyprus);
        cyprus.put("name","Cyprus");
        cyprus.put("is_good", true);
        countriesData.add(cyprus);

        HashMap<String,Object> canada = new HashMap<>();
        canada.put("flag",R.drawable.flag_canada);
        canada.put("name","Canada");
        canada.put("is_good", true);
        countriesData.add(canada);
    }

    private void updateData() {
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                countriesData,
                R.layout.country_cell,
                countryDataStructure, destinationTemplateWidgets);

        /* adapter to map static data to views defined in an XML file */
        countriesListView.setAdapter(simpleAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgets();
        initData();
        updateData();
    }
}