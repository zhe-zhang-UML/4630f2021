package com.example.assignment3zz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity7 extends AppCompatActivity {
    private Button ExperienceButton;
    private Button AthleteButton;
    private Button SingerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        ExperienceButton = (Button) findViewById(R.id.MostExperienceButton);
        ExperienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMEPage();
            }
        });

        AthleteButton = (Button) findViewById(R.id.FavorAthleteButton);
        AthleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMAPage();
            }
        });

        SingerButton = (Button) findViewById(R.id.FavorSingerButton);
        SingerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMSPage();
            }
        });
    }

    public void openMEPage() {
        Intent intentExpericence = new Intent(this, OtherActivity1.class);
        startActivity(intentExpericence);
    }

    public void openMAPage() {
        Intent intentAthlete = new Intent(this, OtherActivity2.class);
        startActivity(intentAthlete);
    }

    public void openMSPage() {
        Intent intentSinger = new Intent(this, OtherActivity3.class);
        startActivity(intentSinger);
    }
}