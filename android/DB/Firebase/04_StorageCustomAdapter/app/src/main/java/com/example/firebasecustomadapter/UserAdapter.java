package com.example.firebasecustomadapter;

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

/**
 * We use this class in order to style the collection of objects (stored in the ArrayList).
 *
 * This is because we wish to present the data in a non-simple way,
 * like we get with the ArrayAdapter which converts the collection's objects' data into a simple string.
 *
 * By using this new adapter which inherits from ArrayAdapter we'll be able to customise the data
 * and place different fields into different views which build the new view which represents the object.
 */
public class UserAdapter extends ArrayAdapter<User> {
	
	ArrayList<User> objects;
	
	int resource;
	
	Context context;
	
	/**
	 * We use this c'tor to create a
	 * @param context
	 * @param resource
	 * @param objects This
	 */
	public UserAdapter(@NonNull Context context, int resource, @NonNull ArrayList<User> objects) {
		super(context, resource, objects);
		this.objects = objects;
		this.context = context;
	}
	
	public View getView(int position /*the line number of the listview*/, View convertView, ViewGroup viewGroup) {
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.new_user_cell,null);
		TextView name = view.findViewById(R.id.userCell_userName);
		TextView age = view.findViewById(R.id.userCell_userAge);
		TextView id = view.findViewById(R.id.userCell_userId);
		ImageView pic = view.findViewById(R.id.userCell_userPicture);
		
		name.setText(objects.get(position).getName());
		age.setText(objects.get(position).getAge()+"");
		id.setText(objects.get(position).getId()+"");
		
		/* Picasso is an external library which gets a url and takes an image from that url,
		* then it inserts the image into a local View in our android application. */
		Picasso.get().load(objects.get(position).getPic()).into(pic);
		
		return view;
	}
}