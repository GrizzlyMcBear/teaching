package com.example.test;

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
import java.util.List;

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
        TextView name = v.findViewById(R.id.name);
        TextView age = v.findViewById(R.id.age);
        TextView id = v.findViewById(R.id.id);
        ImageView pic = v.findViewById(R.id.pic);

        name.setText(objects.get(position).getName());
        age.setText(objects.get(position).getAge()+"");
        id.setText(objects.get(position).getId()+"");
        Picasso.get().load(objects.get(position).getPic()).into(pic);


        return v;
    }
}
