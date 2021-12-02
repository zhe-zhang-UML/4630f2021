package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class settings extends AppCompatActivity {
    RelativeLayout setting_relativeLayout;
    private Button settings_back_btn;
    private RadioButton sound;
    private RadioButton mute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setting_relativeLayout = findViewById(R.id.relativelayout_setting_page);

        settings_back_btn = (Button) findViewById(R.id.setting_page_back_btn);
        settings_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
            }
        } );
        sound = (RadioButton) findViewById(R.id.setting_radio_button1);
        mute = (RadioButton) findViewById(R.id.setting_radio_button2);
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                MediaPlayer ring= MediaPlayer.create(settings.this,R.raw.backgroundmusic);
                ring.start();
                Toast.makeText(getApplicationContext(), "Play The Music", Toast.LENGTH_SHORT).show();
                mute = (RadioButton) findViewById(R.id.setting_radio_button2);
                mute.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        ring.stop();
                        Toast.makeText(getApplicationContext(), "Stop The Music", Toast.LENGTH_SHORT).show();
                    }
                } );
            }
        } );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menu2_back){
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }
        else if(id==R.id.menu2_play){
            startActivity(new Intent(this, play.class));
            return true;
        }
        else if(id==R.id.menu2_rules){
            startActivity(new Intent(this, rules.class));
            return true;
        }
        else if(id==R.id.menu2_settings){
            startActivity(new Intent(this, settings.class));
            return true;
        }
        else if(id==R.id.menu2_about){
            startActivity(new Intent(this, aboutus.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}