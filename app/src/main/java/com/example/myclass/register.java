package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.*;
import static android.widget.Toast.makeText;

public class register extends AppCompatActivity {

    EditText etname,etemail,etpassword;
    Button etadd;
    String stnn,stnl;
    ProgressBar progressBaradd;
    TextView etlogin;

    private ArrayList<GradeItem> mGradeList;
    private ArrayList<LanguageItem> mLanguageList;
    private GradeAdapter mAdapter;
    private LanguageAdapter nAdapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBaradd = findViewById(R.id.progressBarr);
        progressBaradd.setVisibility(View.INVISIBLE);

        etadd = findViewById(R.id.register);
        etlogin = findViewById(R.id.etlogin);

        etname = findViewById(R.id.rname);
        etemail = findViewById(R.id.remail);
        etpassword = findViewById(R.id.rpassword);

        initList();
        initList1();

        Spinner spinnerCountries = findViewById(R.id.spinner_grades);
        Spinner spinnerLanguages = findViewById(R.id.spinner_languages);

        mAdapter = new GradeAdapter(this, mGradeList);
        spinnerCountries.setAdapter(mAdapter);
        nAdapter = new LanguageAdapter(this, mLanguageList);
        spinnerLanguages.setAdapter(nAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GradeItem clickedItem = (GradeItem) parent.getItemAtPosition(position);
                stnn = clickedItem.getGradeName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerLanguages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LanguageItem clickedItem = (LanguageItem) parent.getItemAtPosition(position);
                stnl = clickedItem.getLanguageName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etname.getText().toString();
                String grade = stnn;
                String language = stnl;
                String email = etemail.getText().toString();
                String password = etpassword.getText().toString();
                String is_admin = "0";


                if(isValied(name,email,password)){
                    addclasses(name,grade,language,email,password,is_admin);
                }
            }


        });

        etlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register.this,login.class);
                startActivity(intent);
            }


        });

    }
    private void initList() {
        mGradeList = new ArrayList<>();

        mGradeList.add(new GradeItem("Grade 01", "1"));
        mGradeList.add(new GradeItem("Grade 02", "2"));
        mGradeList.add(new GradeItem("Grade 03", "3"));
        mGradeList.add(new GradeItem("Grade 04", "4"));
        mGradeList.add(new GradeItem("Grade 05", "5"));
        mGradeList.add(new GradeItem("Grade 06", "6"));
        mGradeList.add(new GradeItem("Grade 07", "7"));
        mGradeList.add(new GradeItem("Grade 08", "8"));
        mGradeList.add(new GradeItem("Grade 09", "9"));
        mGradeList.add(new GradeItem("Grade 10", "10"));
        mGradeList.add(new GradeItem("Grade 11", "11"));
    }

    private void initList1() {
        mLanguageList = new ArrayList<>();

        mLanguageList.add(new LanguageItem("ENGLISH", "en"));
        mLanguageList.add(new LanguageItem("සිංහල", "sin"));
        mLanguageList.add(new LanguageItem("தமிழ்", "t"));
    }

    private boolean isValied(String name, String email, String password) {

        if(name.isEmpty()){
            showMessage("Please Enter User Name ");
            return false;
        }
        if(name.length() > 20){
            showMessage("User Name Is Too Long ");
            return false;
        }
        if(email.isEmpty()){
            showMessage("Please Enter the Email ");
            return false;
        }
        if(password.isEmpty()){
            showMessage("Please Enter the Password ");
            return false;
        }
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(email.matches(emailPattern) && name.length() > 0 && email.length() > 0 && password.length() > 0){
            progressBaradd.setVisibility(View.VISIBLE);
            return true;
        }
        showMessage("Please Enter valid Email");
        return false;
    }

    private void showMessage(String msg) {
        makeText(this,msg, LENGTH_SHORT).show();
    }

    private void addclasses( final String name,final String grade,final String language, final String email, final  String password, final String is_admin ){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.register_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    makeText(register.this," Registration Successfully", LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(register.this,login.class);
                    startActivity(intent);

                }
                else {
                    makeText(register.this,"User Name or Email Already Exists", LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(register.this,register.class);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                makeText(register.this, "Please check your Internet Connection", LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());

                Intent intent = new Intent(register.this,register.class);
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name",name);
                params.put("grade", grade);
                params.put("language", language);
                params.put("email", email);
                params.put("password",password);
                params.put("is_admin",is_admin);
                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }


//    public void backsub(View view){
//        Intent intent = new Intent (register.this,login.class);
//        startActivity(intent);
//    }


}