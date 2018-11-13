package com.example.kenne.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");


        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
//        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();


        String name = retrievedFriend.getName();
        String bio = retrievedFriend.getBio();
        Drawable image = getResources().getDrawable(retrievedFriend.getDrawableId());

        TextView name_view = findViewById(R.id.profilename);
        name_view.setText(name);
        TextView bio_view = findViewById(R.id.profilebio);
        bio_view.setText(bio);
        ImageView image_view = findViewById(R.id.profile_imageView);
        image_view.setImageDrawable(image);

//        Log.d("message",retrievedFriend.getName()+retrievedFriend.getBio());
    }

    private class ThisIsAnInnerClass implements RatingBar.OnRatingBarChangeListener(float rating) {
                editor.putInt(rating);
                editor.apply();
    }
}
