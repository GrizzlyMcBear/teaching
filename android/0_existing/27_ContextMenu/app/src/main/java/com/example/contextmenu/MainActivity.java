package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

// todo: option #3 in this legacy explanation seems wrong
/* There are several options to create a context menu:

    1. Calling `registerForContextMenu` and implementing (overriding) the following methods:
        `onCreateContextMenu` and `onContextItemSelected`.

    2. Calling method `setOnLongClickListener` on the view which should open a context menu
        this method must return false.

    3. Using the `setOnClickListener` method, then use the view.startActionMode(new ActionMode.Callback())

    4. Create a popup menu and register it to `setOnMenuItemClickListener`.
 */
public class MainActivity extends AppCompatActivity {

    TextView firstTv;
    TextView anotherTv;
    ImageView imageView;

    private void initWidgets() {
        setContentView(R.layout.activity_main);
        firstTv = findViewById(R.id.first_tv);
        anotherTv = findViewById(R.id.another_tv);
        imageView = findViewById(R.id.image_view);
    }

    /** In this method (option #1) we register several view objects to the context menu,
     read about <a href="https://developer.android.com/reference/android/app/Activity#registerForContextMenu(android.view.View)">`registerForContextMenu`</a>
     As written in the docs this method would connect the view to this activity,
     that is the reason why we have to implement the <a href="https://developer.android.com/reference/android/app/Activity#onCreateContextMenu(android.view.ContextMenu,%20android.view.View,%20android.view.ContextMenu.ContextMenuInfo)">`onCreateContextMenu`</a>
     method. When using this method, we would implement the <a href="https://developer.android.com/reference/android/app/Activity#onContextItemSelected(android.view.MenuItem)">`onContextItemSelected`</a>
     method with whom we'll be able to know which menu item was selected by the app's user.
     */
    private void registerViewForContextMenu() {
        registerForContextMenu(firstTv);
        registerForContextMenu(imageView);
    }

    /** This method is required in order to create the context menu.
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.image_view) {
            // Question: remember what does the `getMenuInflater()` method does?
            getMenuInflater().inflate(R.menu.image_text_view, menu);
        } else if (v.getId() == R.id.first_tv) {
            // Question: any thoughts to improve this method's code?
            getMenuInflater().inflate(R.menu.textview_menu, menu);
        } else {
            // Handle an unexpected input
        }
    }

    /** Implementing this method would allow us to interact and respond to the selected item from the context menu.
     * @apiNote as mentioned in the online documentation, when we desire the normal outcome - we should return false.
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Q: can we improve this method's code?
        /* Hint: try to search for similar/repeating code. */
        switch (item.getItemId()) {
            case R.id.action_save:
                Toast.makeText(this, "Image saved", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_one:
                Toast.makeText(this, "Text view item one selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_two:
                Toast.makeText(this, "Text view item two selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.shahaf:
                Toast.makeText(this, "Text view item Shachaf selected", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onContextItemSelected(item);
    }

    /** In this method (option #2) we add, if it doesn't already exist, the listener for a long click on the view.
     * We can read <a href="https://developer.android.com/reference/android/view/View#setOnLongClickListener(android.view.View.OnLongClickListener)">`setOnLongClickListener`</a>
     * for further documentation.
     */
    private void registerLongClickListener() {

        // In this method call we pass an object we just created (anonymous object)
        firstTv.setOnLongClickListener(new View.OnLongClickListener() {

            // During the creation of this object several methods are being called, some must be overridden.

            @Override
            public boolean onLongClick(View view) {
                /* This method returns a boolean:
                    1. If the return value is `true` android would consume the event and `onCreateActionMode` won't catch it

                    2. When the return value is `false` this means this method is "over" but not finish,
                        in this case android would pass the event of "Long Click" on the view and `onCreateActionMode`
                        would catch and handle it.
                 */
                Toast.makeText(MainActivity.this, "Long click", Toast.LENGTH_SHORT).show();

                /* todo: refactor this explanation:
                    "create menu for the item. don't need longClick"
                 */
                view.startActionMode(new ActionMode.Callback() {

                    /* This method would be called only once - during the creation of the "Action Handling Mechanism" */
                    @Override
                    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                        getMenuInflater().inflate(R.menu.textview_menu, menu);
                        return true;
                    }

                    /* This method would be called after creation and also later -
                        during any time the ActionMode is invalidated. */
                    @Override
                    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                        return false;
                    }

                    /* This method would be called during any time a contextual action button is clicked */
                    @Override
                    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_one:
                                Toast.makeText(MainActivity.this, "Text view item one selected", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.item_two:
                                Toast.makeText(MainActivity.this, "Text view item two selected", Toast.LENGTH_SHORT).show();
                                return true;
                        }

                        return false;
                    }

                    /* This method would be called once the `ActionMode` is closed (and destroyed) */
                    @Override
                    public void onDestroyActionMode(ActionMode actionMode) {}
                });

                return false;
            }
        });
    }

    private void registerRegularClickListener() {
        anotherTv.setOnClickListener(new View.OnClickListener() {

            // This is the well known `onClick` listener.
            @Override
            public void onClick(View view) {

                // Here we create a `PopupMenu` object and use it to "Inflate" a (context) menu
                // Q: remember how we inflated the "Navigation" menu in the past?
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                getMenuInflater().inflate(R.menu.textview_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {

                            case R.id.item_one:
                                Toast.makeText(MainActivity.this, "Text view item one selected", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.item_two:
                                Toast.makeText(MainActivity.this, "Text view item two selected", Toast.LENGTH_SHORT).show();
                                return true;

                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgets();
        registerViewForContextMenu();// Using option #1
        registerLongClickListener();// Using option #2
        registerRegularClickListener();
    }
}