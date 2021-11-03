package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

public class settings extends AppCompatActivity {
    RelativeLayout setting_relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setting_relativeLayout = findViewById(R.id.relativelayout_setting_page);
    }
}