package com.kiran.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.kiran.myapplication.R;


public class Flash_page extends AppCompatActivity{
    private static int SPLASH_TIME_OUT=1500;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashpage);
        getSupportActionBar().hide();
        final ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.pb);
        iv=(ImageView)findViewById(R.id.im);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                simpleProgressBar.setVisibility(View.VISIBLE);
                Intent splashIntent = new Intent(Flash_page.this, Login.class);
                simpleProgressBar.setVisibility(View.VISIBLE);

                startActivity(splashIntent);
                finish();
            }

        },SPLASH_TIME_OUT);




    }
}
