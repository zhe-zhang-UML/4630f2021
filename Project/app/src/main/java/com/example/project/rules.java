package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

public class rules extends AppCompatActivity {
    RelativeLayout rule_relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        rule_relativeLayout = findViewById(R.id.relativelayout_rules_page);
    }
}