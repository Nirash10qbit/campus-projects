package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class analysesub extends AppCompatActivity {

    String stn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysesub);

        stn = getIntent().getExtras().getString("uname");
    }
    public void backan(View view){
        Intent intent = new Intent(this,analyse.class);
        intent.putExtra("uname", stn);
        startActivity(intent);
        finish();
    }
}