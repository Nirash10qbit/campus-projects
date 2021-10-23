package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class editsubject extends AppCompatActivity {

    String stn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editsubject);

        stn = getIntent().getExtras().getString("uname");
    }
}