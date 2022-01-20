package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseReference myRef;
    FirebaseDatabase database;
    Button create, add, btnPic;
    EditText name, id, age;
    ListView listView;
    ImageView imageView;
    int index = 1;
    ArrayList<User> arrayList = new ArrayList<>();
    ArrayAdapter<User> arrayAdapter ;
    MyAdapter userMyAdapter;
    StorageReference storageRef = FirebaseStorage.getInstance().getReference();
    String nameInput, pic="" ;
    int ageInput ;
    int idInput;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    User user;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create = findViewById(R.id.create);
        add = findViewById(R.id.add);
        name = findViewById(R.id.name);
        btnPic = findViewById(R.id.btn_pic);
        imageView = findViewById(R.id.iv);
        id = findViewById(R.id.id);
        age = findViewById(R.id.age);
        listView = findViewById(R.id.listview);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("DATA");
        
        btnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                } catch (ActivityNotFoundException e) {
                    // display error state to the user
                }
            }
        });
        
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameInput = name.getText().toString();
                ageInput = Integer.parseInt(age.getText().toString());
                idInput = Integer.parseInt(id.getText().toString());
                user = new User(nameInput, ageInput, idInput,pic);
                myRef.child("USERS").child(user.getName()+" "+index).setValue(user);
                index++;
                Query q = myRef.child("USERS");
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        arrayList.clear();
                        for (DataSnapshot dst: snapshot.getChildren() ) {
                            User u = dst.getValue(User.class);
                            arrayList.add(u);
                        }
                        refreshList();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) { }
                });
            }
        });
        
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create100Users();
                refreshList();
            }
        });
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras(); //Bundles are generally used for passing data between various Android activities. It depends on you what type of values you want to pass, but bundles can hold all types of values and pass them to the new activity.
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);//0 means compress for the smallest size. 100 means compress for max visual quality.
            byte[] data1 = baos.toByteArray(); //Shrinking the photo to byte array
            nameInput = name.getText().toString();
            UploadTask uploadTask = storageRef.child("profile").child(nameInput).putBytes(data1); //create new file in storage
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {/*Listener called when a Task fails with an exception.
                 
                 */
                    // Handle unsuccessful uploads
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                    // ...task Represents an asynchronous operation.
                    Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl(); //To retrieve a download URL
                    while(!((Task<?>) uri).isComplete());//Returns true if the Task is complete; false otherwise.
                    
                    Uri url = uri.getResult();  //URI contains both URL and URN to identify the name and location
                    // or both of a resource; in contrast, URL is a subset of URI and only identifies the location of the resource.
                    // The example of URI is urn:isbn:0-476-27557-4, whereas the example of URL, is https://google.com
                    
                    pic = url.toString();
                    Log.d("pic",pic);
                }
            });
        }
    }
    
    public void refreshList() {
        //arrayAdapter = new ArrayAdapter<User>(this, R.layout.user_cell, R.id.user_text, arrayList);
        userMyAdapter = new MyAdapter(this, R.layout.new_user_cell, arrayList);
        listView.setAdapter(userMyAdapter);
    }
    
    public void create100Users() {
        for (int i = 1; i <= 100; i++) {
            User u = new User("user "+i, 30,1111,"+++");
            myRef.child("USERS").child(u.getName()).setValue(u);
        }
    }
}