package com.kiran.myapplication.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kiran.myapplication.Activities.Develop;
import com.kiran.myapplication.Activities.Login;
import com.kiran.myapplication.PreferenceHelper;
import com.kiran.myapplication.R;

public class Profile extends AppCompatActivity {

    private TextView tvname, tvemail, tvmobile, tvaddress,develop;
    private Button btnlogout;
    private ImageView img;
    private PreferenceHelper preferenceHelper;
    private ImageButton logout;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        androidx.appcompat.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        BottomNavigationView bottomNavigationView = findViewById(R.id.b_nav);

        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater=(LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.ic_icon, null);
        actionBar.setCustomView(view);

        img=(ImageView) findViewById(R.id.dev_img);
        preferenceHelper = new PreferenceHelper(this);
        logout=(ImageButton)findViewById(R.id.logout);
        tvname = (TextView) findViewById(R.id.prof_name);
        tvemail = (TextView) findViewById(R.id.prof_email);
        tvmobile = (TextView) findViewById(R.id.prof_mobile);
        develop = (TextView) findViewById(R.id.develop);
//        btnlogout = (Button) findViewById(R.id.btn);


        tvname.setText("Welcome "+preferenceHelper.getName());
        tvemail.setText(" "+preferenceHelper.getEmail());
        tvmobile.setText(" "+preferenceHelper.getName());
//        tvaddress.setText(" "+preferenceHelper.getAddress());



develop.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(Profile.this, "Redirecting", Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(Profile.this, Develop.class);
        startActivity(intent);
    }
});


      bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(), Suggested_user.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.homepage:
                        startActivity(new Intent(getApplicationContext(), Homepage.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        return true;
                }
                return false;
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferenceHelper.putIsLogin(false);
                Intent intent = new Intent(Profile.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Profile.this.finish();
            }
        });
    }
}