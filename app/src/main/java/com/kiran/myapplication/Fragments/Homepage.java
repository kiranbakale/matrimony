package com.kiran.myapplication.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kiran.myapplication.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Homepage extends AppCompatActivity {
TextView name,likes,caption,name1,likes1,caption1;
ImageView post,post1;
CircleImageView circle,circle1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.polariods);
         circle=(CircleImageView)findViewById(R.id.idCVAuthor);
         name=(TextView)findViewById(R.id.idTVAuthorName);
         likes=(TextView)findViewById(R.id.idTVLikes);
         post=(ImageView)findViewById(R.id.idIVPost);
         caption=(TextView)findViewById(R.id.idTVPostDesc);
         circle1=(CircleImageView)findViewById(R.id.idCVAuthor1);
         name1=(TextView)findViewById(R.id.idTVAuthorName1);
         likes1=(TextView)findViewById(R.id.idTVLikes1);
         post1=(ImageView)findViewById(R.id.idIVPost1);
         caption1=(TextView)findViewById(R.id.idTVPostDesc);
            androidx.appcompat.app.ActionBar actionBar=getSupportActionBar();
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action));
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            BottomNavigationView bottomNavigationView = findViewById(R.id.b_nav);


            actionBar.setDisplayShowCustomEnabled(true);
            LayoutInflater inflater=(LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(R.layout.ic_icon, null);
            actionBar.setCustomView(view);

//            BottomNavigationView bottomNavigationView = findViewById(R.id.b_nav);



            bottomNavigationView.setSelectedItemId(R.id.homepage);

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case R.id.user:
                            startActivity(new Intent(getApplicationContext(), Suggested_user.class));
                            overridePendingTransition(0,0);
                            return true;

                        case R.id.homepage:
                            return true;

                        case R.id.profile:
                            startActivity(new Intent(getApplicationContext(), Profile.class));
                            overridePendingTransition(0,0);
                            return true;
                    }
                    return false;
                }
            });
        }
    }
