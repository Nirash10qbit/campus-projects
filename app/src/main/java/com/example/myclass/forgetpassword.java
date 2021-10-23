package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class forgetpassword extends AppCompatActivity {

    String stn;
    EditText etname;
    ProgressBar progressBar;
    TextView etlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        stn = getIntent().getExtras().getString("uname");

        etname = findViewById(R.id.fpname);
        progressBar = findViewById(R.id.progressBarfp);

        etlog = findViewById(R.id.etfplog);

        progressBar.setVisibility(View.INVISIBLE);

        etlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forgetpassword.this,login.class);
                intent.putExtra("uname", stn);
                startActivity(intent);
            }
        });

    }

    public void fpbutton(View view) {

        String uname = etname.getText().toString();

        if (isValied(uname)){
            loginl(uname);
        }
    }

    private boolean isValied(String uname) {

        if (uname.isEmpty()){
            showMessage("UserName is empty");
            etname.setText(null);
            return false;
        }

        progressBar.setVisibility(View.VISIBLE);
        return true;

    }



    private void loginl(final String uname) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.fpassword_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                if (response.equals("success")) {
                    Toast.makeText(forgetpassword.this,"Please Check your Email", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(forgetpassword.this,login.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(forgetpassword.this,"Invalid User Name", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(forgetpassword.this,forgetpassword.class);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(forgetpassword.this, "Please check your Internet Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(forgetpassword.this,forgetpassword.class);
                intent.putExtra("uname", stn);
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("uname", uname);
                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    private void showMessage(String msg) { Toast.makeText(this,msg , Toast.LENGTH_SHORT).show(); }

}