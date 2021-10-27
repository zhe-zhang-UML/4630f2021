package com.example.assignment3zz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity5 extends AppCompatActivity {
    private Button MineButton;
    private Button FamilyButton;
    private Button SisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        MineButton = (Button) findViewById(R.id.MyInvestButton);
        MineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMIPage();
            }
        });

        FamilyButton = (Button) findViewById(R.id.FamilyInvestButton);
        FamilyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openFIPage();
            }
        });

        SisterButton = (Button) findViewById(R.id.SisterInvestButton);
        SisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSIPage();
            }
        });
    }

    public void openMIPage() {
    Intent intentinvest = new Intent(this, InvestActivity1.class);
    startActivity(intentinvest);
    }

    public void openFIPage() {
    Intent intentinvest1 = new Intent(this, InvestActivity2.class);
    startActivity(intentinvest1);
    }

    public void openSIPage() {
    Intent intentinvest2 = new Intent(this, InvestActivity3.class);
    startActivity(intentinvest2);
    }
}