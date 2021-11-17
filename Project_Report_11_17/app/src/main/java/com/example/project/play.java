package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class play extends AppCompatActivity {
    private Button back_btn;
    private Button undo_white_btn;
    private Button undo_black_btn;
    private Button reset_btn;
    private chessboard chess_board;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        chess_board = (chessboard) findViewById(R.id.chessboard);
        back_btn = (Button) findViewById(R.id.play_page_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
            }
        } );
        undo_white_btn = (Button) findViewById(R.id.play_page_undo_white_btn);
        undo_white_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                chess_board.undo_white();
            }
        } );
        undo_black_btn = (Button) findViewById(R.id.play_page_undo_black_btn);
        undo_black_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                chess_board.undo_black();
            }
        } );
        reset_btn = (Button) findViewById(R.id.play_page_reset_btn);
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                chess_board.start();
            }
        } );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menu_back){
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }
        else if (id==R.id.menu_start_new) {
            chess_board.start();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}