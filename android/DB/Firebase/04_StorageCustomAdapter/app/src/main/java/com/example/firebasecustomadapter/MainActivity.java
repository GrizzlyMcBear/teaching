package com.example.firebasecustomadapter;

import static android.widget.Toast.*;
import static java.lang.String.*;

import java.io.ByteArrayOutputStream;

import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class MainActivity extends AppCompatActivity {
	
	static final int REQUEST_IMAGE_CAPTURE = 1;
	static final String UPLOAD_TAG = "Firebase_UploadingData";
	static final String DOWNLOAD_TAG = "Firebase_DownloadingPicture";
	
	int index = 1;// TODO: move this counter to a shared preference to be preserved
	String userPicture = "";
	
	DatabaseReference databaseReference;
	FirebaseDatabase firebaseDatabase;
	
	Button createUsersButton;
	Button addUser;
	Button takePicture;
	EditText userName;
	EditText userId;
	EditText userAge;
	ListView existingUsers;
	ImageView newPicture;
	
	ArrayList<User> arrayList = new ArrayList<>();
	ArrayAdapter<User> arrayAdapter;
	UserAdapter myUserAdapter;
	StorageReference storageReference;
	
	private void initWidgets() {
		setContentView(R.layout.activity_main);
		
		createUsersButton = findViewById(R.id.createUsersButton);
		
		takePicture = findViewById(R.id.takePictureButton);
		newPicture = findViewById(R.id.pictureImageView);
		
		addUser = findViewById(R.id.addNewUserButton);
		userName = findViewById(R.id.userName);
		userId = findViewById(R.id.userId);
		userAge = findViewById(R.id.userAge);
		
		existingUsers = findViewById(R.id.existingUsers);
	}
	
	private void initDataProviders() {
		firebaseDatabase = FirebaseDatabase.getInstance();
		databaseReference = firebaseDatabase.getReference("DATA");
		storageReference = FirebaseStorage.getInstance().getReference();
	}
	
	private void initWidgetsListeners() {
		takePicture.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				// Use the camera with an implicit intent and a unique request code.
				Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				try {
					startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
				} catch (ActivityNotFoundException e) {
					// TODO: display error state to the user
				}
			}
		});
		addUser.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("DefaultLocale")
			@Override
			public void onClick(View v) {
				
				// Obtain user's data and use it to create a user object
				String name = userName.getText().toString();
				// TODO: handle invalid input (i.e. use `tryParse()` from `Guava` lib, write a polyfill etc.)
				int age = Integer.parseInt(userAge.getText().toString());
				int id = Integer.parseInt(userId.getText().toString());
				User user = new User(name, age, id, userPicture);
				
				// Add the user into the DB, then increment index
				String userUID = format("%s %d", user.getName(), index);
				databaseReference.child("USERS").child(userUID).setValue(user);
				index++;
				
				// Reload all users from DB and replace content of ArrayList
				Query query = databaseReference.child("USERS");
				query.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(@NonNull DataSnapshot snapshot) {
						arrayList.clear();
						for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
							User user = dataSnapshot.getValue(User.class);
							arrayList.add(user);
						}
						refreshList();
					}
					
					@Override
					public void onCancelled(@NonNull DatabaseError error) { }
				});
			}
		});
		createUsersButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// Create a variable amount of users
				createUsers(10);
				refreshList();
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initWidgets();
		initDataProviders();
		initWidgetsListeners();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		// If the request code and result match proceed to handle the (extra) image data
		if (requestCode != REQUEST_IMAGE_CAPTURE || resultCode != RESULT_OK)
			return;
		
		// KD: Bundles are generally used for passing data between various Android activities. It depends on you what type of values you want to\\
		// Obtain the image and manipulate it for presentation
		Bundle extras = data.getExtras();
		Bitmap image = (Bitmap)extras.get("data");
		newPicture.setImageBitmap(image);
		
		// Convert the image into a byte array
		ByteArrayOutputStream imageOutputStream = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, imageOutputStream);
		byte[] imageByteArray = imageOutputStream.toByteArray();
		
		// Upload the image to firebase's storage
		String name = userName.getText().toString();// TODO: add validation to name (can't be null/empty string).
		UploadTask uploadTask;
		try {
			uploadTask = storageReference.child("profile").child(name).putBytes(imageByteArray);
			uploadTask.addOnFailureListener(new OnFailureListener() {
				// Handle unsuccessful uploads
				@Override
				public void onFailure(@NonNull Exception exception) {
					makeText(MainActivity.this, "Failed to upload image.", LENGTH_LONG).show();
				}
			}).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
				@Override
				public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
					// TODO (question): what should I elaborate regarding this comment?
					// taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
					
					// TODO (question): update this code to use `addOnCompleteListener` instead of the `while` loop
					// KD: taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
					// ...task Represents an asynchronous operation.
					Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();//To retrieve a download URL
					while (!((Task<?>) uri).isComplete());//Returns true if the Task is complete; false otherwise.
					Uri url = uri.getResult();
					userPicture = url.toString();
					Log.d(DOWNLOAD_TAG, userPicture);
				}
			});
		} catch (Exception exception) {
			String message = format("Exception while uploading image to firebase DB:\n%s", exception.toString());
			Log.e(UPLOAD_TAG, message);
			makeText(this, message, LENGTH_LONG).show();
		}
	}
	
	/**
	 * In order to update the {@link ListView} with the users' data, presented in a custom way
	 * and not a simple stringification of the {@link User}'s object contents -
	 * we'll use a dedicated class ({@link UserAdapter}) we created which converts the data
	 * into a desired visual representation.
	 */
	public void refreshList() {
		//arrayAdapter = new ArrayAdapter<User>(this, R.layout.user_cell, R.id.user_text, arrayList);
		myUserAdapter = new UserAdapter(this, R.layout.new_user_cell, arrayList);
		existingUsers.setAdapter(myUserAdapter);
	}
	
	private void createUsers(int amount) {
		String name;
		int age;
		int id;
		Random random = new Random();
		final int AGE_LIMIT = 120;
		
		for (int i = 1; i <= amount; i++) {
			name = format("User%d", i);
			age = random.nextInt(AGE_LIMIT);
			id = random.nextInt();
			
			User user = new User(name, age, id,"+++");
			databaseReference.child("USERS").child(user.getName()).setValue(user);
		}
	}
}