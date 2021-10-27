package com.example.assignment3zz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Button HappyBirButton;
    private Button WhereFromButton;
    private Button FactMeButton;
    private Button InvestPortButton;
    private Button ResumeMeButton;
    private Button OtherButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HappyBirButton = (Button) findViewById(R.id.HappyButton);
        HappyBirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHBPage();

            }
        });

        WhereFromButton = (Button) findViewById(R.id.WeatherWhereButton);
        WhereFromButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWWPage();

            }
        });

        FactMeButton = (Button) findViewById(R.id.FactButton);
        FactMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFMPage();

            }
        });

        InvestPortButton = (Button) findViewById(R.id.PortfolioButton);
        InvestPortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIPPage();

            }
        });

        ResumeMeButton = (Button) findViewById(R.id.ResumeButton);
        ResumeMeButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                openRMPage();

           }
        });

        OtherButton = (Button) findViewById(R.id.OtherButton);
        OtherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOTPage();

            }
        });
    }

    public void openHBPage() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void openWWPage() {
        Intent intent1 = new Intent(this, MainActivity3.class);
        startActivity(intent1);
    }

    public void openFMPage() {
        Intent intent2 = new Intent(this, MainActivity4.class);
        startActivity(intent2);
    }

    public void openIPPage() {
        Intent intent3 = new Intent(this, MainActivity5.class);
        startActivity(intent3);
    }

    public void openRMPage() {
        Intent intent4 = new Intent(this, MainActivity6.class);
        startActivity(intent4);
    }

    public void openOTPage() {
        Intent intent5 = new Intent(this, MainActivity7.class);
        startActivity(intent5);
    }

}