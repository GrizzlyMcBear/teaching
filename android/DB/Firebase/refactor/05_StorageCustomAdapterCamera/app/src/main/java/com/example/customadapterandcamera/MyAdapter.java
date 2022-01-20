package com.example.customadapterandcamera;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<User> {
	
	ArrayList<User> objects;
	int resource;
	Context context;
	
	public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<User> objects) {
		super(context, resource, objects);
		this.objects = objects;
		this.context = context;
	}
	
	public View getView(int position /*the line number of the listview*/, View convertView, ViewGroup viewGroup)
	{
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.new_user_cell,null);
		TextView name = v.findViewById(R.id.newUserCell_userName_textView);
		TextView age = v.findViewById(R.id.userAge);
		TextView id = v.findViewById(R.id.userId);
		ImageView pic = v.findViewById(R.id.userPicture);
		
		name.setText(objects.get(position).getName());
		age.setText(objects.get(position).getAge()+"");
		id.setText(objects.get(position).getId()+"");
		Picasso.get().load(objects.get(position).getPic()).into(pic);
		
		return v;
	}
}