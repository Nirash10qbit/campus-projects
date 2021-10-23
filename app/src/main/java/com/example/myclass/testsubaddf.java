package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class testsubaddf extends AppCompatActivity {

    String tstn,ttotal,ttmarks;
    Button etadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testsubaddf);



        etadd = findViewById(R.id.radds22);

        tstn = "3";
        ttmarks = "40";
        ttotal = "90";

        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    addclasses(tstn,ttmarks,ttotal);
            }
        });

    }

    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



    private void addclasses( final String tstn, final String ttmarks, final  String ttotal){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updatedata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    Toast.makeText(testsubaddf.this," Successfully Access data", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(testsubaddf.this,testsubaddf.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(testsubaddf.this,"Error", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(testsubaddf.this,testsubaddf.class);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(testsubaddf.this, "Please check your Internet Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                Intent intent = new Intent(testsubaddf.this,testsubaddf.class);
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("tstn",tstn);
                params.put("tmarks",ttmarks);
                params.put("ttotal", ttotal);

                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}