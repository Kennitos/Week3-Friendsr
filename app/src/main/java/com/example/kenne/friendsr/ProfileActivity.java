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

    Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");


//        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
//        SharedPreferences.Editor editor = prefs.edit();
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

        RatingBar rating = findViewById(R.id.ratingBar);
        rating.setNumStars(5);

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float aStoredFloat = prefs.getFloat("rating "+ retrievedFriend.getName(),0);

        if (aStoredFloat != 0) {
            // we have something stored under "example_key"
            rating.setRating(aStoredFloat);
        }
        else {
            // there is nothing stored under "example_key"
            rating.setOnRatingBarChangeListener(new ThisIsAnInnerClass());
        }

        rating.setOnRatingBarChangeListener(new ThisIsAnInnerClass());

//        Log.d("message",retrievedFriend.getName()+retrievedFriend.getBio());
    }

    private class ThisIsAnInnerClass implements RatingBar.OnRatingBarChangeListener{
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat("rating "+ retrievedFriend.getName(), v);
            editor.apply();
        }
    }
}
