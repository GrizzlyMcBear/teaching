package com.example.basicfirebaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

/** This class implements writing and reading data from the `Firestore` cloud DB.
 * @implNote in order to duplicate this app and for it to perform correctly, one should:
 *  <ol>
 *      <li>Setup your Firestore account (documentation could be found <a href="https://firebase.google.com/docs/android/setup">Add Firebase to your Android project</a>.</li>
 *      <li>Read and implement the code for <a href="https://firebase.google.com/docs/firestore/quickstart#java_4">Get started with Cloud Firestore</a>.</li>
 *      <li>After creating your cloud DB, one should:
 *          <ol>
 *              <li>Go to the <a href="https://console.firebase.google.com/u/0/">Firebase console page</a></li>
 *              <li>Under <b>Build</b>, go to <b>Firestore Database</b>.</li>
 *              <li>Then in the tabs (<i>Data</i>, <i>Rules</i>, <i>Indexes</i> and <i>Usage</i>) select <b>Rules</b>.</li>
 *              <li>Change the line <i>allow read, write: if false;</i> into <i>allow read, write: if <b>true</b>;</i></li>
 *              <li><b>Note:</b> this is for development purposes only.</li>
 *          </ol>
 *      </li>
 *      <li>General instructions could be found at <a href="https://firebase.google.com/docs/firestore">Cloud Firestore</a>.</li>
 *      <li>Known issues and fixes:
 *          <ol>
 *              <li><i>firestore: PERMISSION_DENIED: Missing or insufficient permissions</i>
 *              <a href="https://stackoverflow.com/questions/46590155/firestore-permission-denied-missing-or-insufficient-permissions"> stackoverflow solution</a>.</li>
 *              <li><i>V/FA: Inactivity, disconnecting from the service</i>
 *              <a href="https://stackoverflow.com/questions/46080700/v-fa-inactivity-disconnecting-from-the-service"> stackoverflow solution</a>.</li>
 *          </ol>
 *      </li>
 *  </ol>
 *
 */
public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    private final String FIREBASE_DB_TAG = "adding_firebase_data";

    private EditText firstNameEditText;
    private EditText middleNameEditText;
    private EditText lastNameEditText;
    private EditText birthYearEditText;

    private void initWidgets() {
        setContentView(R.layout.activity_main);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        middleNameEditText = findViewById(R.id.middleNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        birthYearEditText = findViewById(R.id.birthYearEditText);
    }

    private void initCloudFirestore() {
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    private void resetEditTextWidgets() {
        firstNameEditText.setText("");
        middleNameEditText.setText("");
        lastNameEditText.setText("");
        birthYearEditText.setText("");
    }

    private void readAndPrintUsers() {
        firebaseFirestore.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(FIREBASE_DB_TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(FIREBASE_DB_TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWidgets();
        initCloudFirestore();
    }

    public void addPersonOnClickHandler(View view) {
        // Create a new user with a first, middle, and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", firstNameEditText.getText().toString());
        user.put("middle", middleNameEditText.getText().toString());
        user.put("last", lastNameEditText.getText().toString());
        user.put("born", Integer.parseInt(birthYearEditText.getText().toString()));

        // Add a new document with a generated ID
        firebaseFirestore.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(FIREBASE_DB_TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(FIREBASE_DB_TAG, "Error adding document", e);
                    }
                });
        resetEditTextWidgets();
    }

    public void printUsersOnClickHandler(View view) {
        readAndPrintUsers();
    }
}