package com.kiran.myapplication.Activities;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.kiran.myapplication.R;

public class Develop extends AppCompatActivity {
    WebView develop1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.develop);
        getSupportActionBar().hide();

        develop1=(WebView) findViewById(R.id.develop);
        develop1.loadUrl("https://kiranbakale.github.io/Portfolio/");

    }
}
