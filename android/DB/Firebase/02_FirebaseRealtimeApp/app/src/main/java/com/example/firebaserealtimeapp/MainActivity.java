package com.example.firebaserealtimeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	
	DatabaseReference databaseReference;
	FirebaseDatabase firebaseDatabase;
	Button create, add;
	EditText name, id, age;
	ListView listView;
	int index = 1;
	ArrayList<User> arrayList = new ArrayList<>();
	ArrayAdapter<User> arrayAdapter ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		create = findViewById(R.id.create);
		add = findViewById(R.id.add);
		name = findViewById(R.id.name);
		id = findViewById(R.id.id);
		age = findViewById(R.id.age);
		listView = findViewById(R.id.listview);
		firebaseDatabase = FirebaseDatabase.getInstance();
		databaseReference = firebaseDatabase.getReference("DATA");
		
		
		
		
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String nameInput = name.getText().toString();
				int ageInput = Integer.parseInt(age.getText().toString());
				int idInput = Integer.parseInt(id.getText().toString());
				
				User user = new User(nameInput, ageInput, idInput);
				databaseReference.child("USERS").child(user.getName()+" "+index).setValue(user);
				index++;
				
				Query q = databaseReference.child("USERS");
				q.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(@NonNull DataSnapshot snapshot) {
						arrayList.clear();
						
						for(DataSnapshot dst: snapshot.getChildren() )
						{
							User u = dst.getValue(User.class);
							arrayList.add(u);
						}
						refreshList();
					}
					
					@Override
					public void onCancelled(@NonNull DatabaseError error) {}
				});
			}
		});
		
		create.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				create100Users();
				
				
			}
		});
	}
	
	
	
	
	public void refreshList()
	{
		
		arrayAdapter = new ArrayAdapter<User>(this, R.layout.user_cell, R.id.user_text, arrayList);
		listView.setAdapter(arrayAdapter);
		
	}
	
	
	public void create100Users()
	{
		for (int i = 1; i <= 100; i++) {
			User u = new User("user "+i, 30,1111);
			databaseReference.child("USERS").child(u.getName()).setValue(u);
		}
	}
}