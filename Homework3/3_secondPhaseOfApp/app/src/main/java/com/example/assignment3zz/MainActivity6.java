package com.example.assignment3zz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;


public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        PDFView pdfView = findViewById(R.id.pdfView);

        pdfView.fromAsset("resume.pdf").load();

    }
}