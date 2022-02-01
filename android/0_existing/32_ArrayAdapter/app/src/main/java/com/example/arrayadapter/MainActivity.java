package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** In this screen we present a list of colors (longer than the screen) and enable the user to add
 * more items to it at the end, allowing duplications.
 *
 * @implNote We implement this screen by defining a {@link ListView} with the initial colors,
 * and add a new one at the end after each "insert" action.
 */
public class MainActivity extends AppCompatActivity {

    public ListView listView;
    public EditText colorEt;
    Button addBtn;
    ArrayAdapter<String> adapter;/* The `ArrayAdapter` returns a `View` for each object in the passed collection
                                    to populate a list-based UI widget. */

    final String[] colors = { "Purple", "Red", "Yellow", "Green", "Blue", "Black", "Purple", "Red",
            "Yellow", "Green", "Blue", "Black", "Purple", "Red", "Yellow", "Green", "Blue", "Black" };

    /** <p>
     *  Q: Why do we use an {@link ArrayList}?<br/>
     *  A: The {@link ListView} widget requires its data to be defined as a {@link java.util.List}.
     * </p>
     * <p>
     *  Q: What does the command {@link Arrays#asList(Object[])} do?<br/>
     *  A: It converts the `colors` array into a List.
     * </p>
      */
    final ArrayList<String> colorsList  = new ArrayList<>(Arrays.asList(colors));

    private void initWidgets() {
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.my_list);
        colorEt = findViewById(R.id.color_input);
        addBtn = findViewById(R.id.add_btn);
        initDataProviders();
        initWidgetsListeners();
    }

    private void initDataProviders() {
        // Here we pass the `colorsList` in order to (later) populate the `ListView` widget
        adapter = new ArrayAdapter<String>(this,
                // The `android.R.layout.simple_list_item_1` is a default layout by android, other option is to create one
                android.R.layout.simple_list_item_1,
                colorsList);

        // Connect the `listView` to the `adapter`, this would allow updating the data.
        listView.setAdapter(adapter);
    }

    private void initWidgetsListeners() {
        // We can add more behaviour to each list item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String message = String.format("Color chosen %s", colorsList.get(i));
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String color = colorEt.getText().toString();
                colorsList.add(color);
                Log.e("Added colors", Arrays.toString(colors));
                Log.e("Added colors", Arrays.toString(colorsList.toArray()));

                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgets();
    }
}