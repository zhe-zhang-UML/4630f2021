package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

public class aboutus extends AppCompatActivity {
    RelativeLayout about_relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        about_relativeLayout = findViewById(R.id.relativelayout_about_page);
    }
}