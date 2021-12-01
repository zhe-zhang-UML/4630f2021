package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout main_relativeLayout;
    private Button main_page_play;
    private Button main_page_rules;
    private Button main_page_settings;
    private Button main_page_about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_relativeLayout = findViewById(R.id.relativelayout_main_page);

        main_page_play = (Button) findViewById(R.id.play_btn);
        main_page_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openPlayActivity();
            }
        } );
        main_page_rules = (Button) findViewById(R.id.rule_btn);
        main_page_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openRuleActivity();
            }
        } );
        main_page_settings = (Button) findViewById(R.id.setting_btn);
        main_page_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openSettingsActivity();
            }
        } );
        main_page_about = (Button) findViewById(R.id.about_btn);
        main_page_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                openAboutActivity();
            }
        } );
    }
    public void openPlayActivity() {
        Intent intent = new Intent(this,play.class);
        startActivity(intent);
    }
    public void openRuleActivity() {
        Intent intent = new Intent(this,rules.class);
        startActivity(intent);
    }
    public void openSettingsActivity() {
        Intent intent = new Intent(this,settings.class);
        startActivity(intent);
    }
    public void openAboutActivity() {
        Intent intent = new Intent(this,aboutus.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu3, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menu_exit){
            MainActivity.this.finish();
            System.exit(0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}