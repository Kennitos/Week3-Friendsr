package com.example.kenne.friendsr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends;

    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = friends.get(position).getName();
        String bio = friends.get(position).getBio();
        Drawable image = getContext().getResources().getDrawable(friends.get(position).getDrawableId());

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        TextView name_view = convertView.findViewById(R.id.nameView);
        name_view.setText(name);

        ImageView image_view = convertView.findViewById(R.id.imageView);
        image_view.setImageDrawable(image);

        return convertView;
    }
}
