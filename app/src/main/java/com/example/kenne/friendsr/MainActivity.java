package com.example.kenne.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Friend> friends = new ArrayList<>();

        int carlos_id = getResources().getIdentifier("carlos","drawable", getPackageName());
        Friend carlos = new Friend("Carlos Sainz","55",carlos_id);

        int daniel_id = getResources().getIdentifier("daniel","drawable", getPackageName());
        Friend daniel= new Friend("Daniel Ricciaroo","3",daniel_id);

        int fernando_id = getResources().getIdentifier("fernando","drawable", getPackageName());
        Friend fernando = new Friend("Fernando Alonso","14",fernando_id);

        int kimi_id = getResources().getIdentifier("kimi","drawable", getPackageName());
        Friend kimi = new Friend("Kimi Raikonnen","7",kimi_id);

        int lewis_id = getResources().getIdentifier("lewis","drawable", getPackageName());
        Friend lewis = new Friend("Lewis Hamilton","44",lewis_id);

        int nico_id = getResources().getIdentifier("nico","drawable", getPackageName());
        Friend nico = new Friend("Nico Rosberg","6",nico_id);

        int nicoh_id = getResources().getIdentifier("nico_h","drawable", getPackageName());
        Friend nicoh = new Friend("Nico Hulkenberg","27",nicoh_id);

        int valtteri_id = getResources().getIdentifier("valtteri","drawable", getPackageName());
        Friend valtteri = new Friend("Valtteri Botas","77",valtteri_id);

        int sebas_id = getResources().getIdentifier("vettel","drawable", getPackageName());
        Friend sebas = new Friend("Sebastian Vettel","5",sebas_id);

        friends.add(carlos);
        friends.add(daniel);
        friends.add(fernando);
        friends.add(kimi);
        friends.add(lewis);
        friends.add(nico);
        friends.add(nicoh);
        friends.add(valtteri);
        friends.add(sebas);

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item , friends);
        GridView gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new ThisIsAnInnerClass());

    }

    private class ThisIsAnInnerClass implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d("clicked","message");
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);
            Log.d(clickedFriend.getName(),"index: "+i);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);

        }
    }





}
