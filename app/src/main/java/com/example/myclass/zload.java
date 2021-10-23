package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class zload extends AppCompatActivity {

    String st1,st8,st9,stn,stl,stg,sta;
    TextView tv1,tv2,tv3,tv4;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zload);

        tv1 = findViewById(R.id.loadname);
        stn = getIntent().getExtras().getString("uname");
        tv1.setText(stn);

        lv = findViewById(R.id.lalist);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {


                tv2 = view.findViewById(R.id.tvlanguage);
                stl = tv2.getText().toString();

                tv3 = view.findViewById(R.id.tvgrade);
                stg = tv3.getText().toString();

                tv4 = view.findViewById(R.id.tvisadmin);
                sta = tv4.getText().toString();


                getIntent().getExtras().getString("value");
                getIntent().getExtras().getString("gid");

                st1 = "10";
                int a = st1.length();
                int b = sta.length();

                st8 = "sin";
                st9 = "en";
                int leone = st8.length();
                int lezero = st9.length();
                int letwo = stl.length();

                if (a == b) {
                    Intent intent = new Intent(getApplicationContext(), menus.class);
                    intent.putExtra("uname", stn);
                    startActivity(intent);

                } else {

                    if (leone == letwo) {

                        Intent intent = new Intent(getApplicationContext(), zmenus.class);
                        intent.putExtra("uname", stn);
                        intent.putExtra("language", stl);
                        intent.putExtra("grade", stg);

                        startActivity(intent);

                    } else if (lezero == letwo) {

                        Intent intent = new Intent(getApplicationContext(), zmenue.class);
                        intent.putExtra("uname", stn);
                        intent.putExtra("language", stl);
                        intent.putExtra("grade", stg);

                        startActivity(intent);

                    } else {
                        Intent intent = new Intent(getApplicationContext(), zmenut.class);
                        intent.putExtra("uname", stn);
                        intent.putExtra("language", stl);
                        intent.putExtra("grade", stg);
                        startActivity(intent);
                    }
                }
            }
        });
    }
    protected void onResume(){
        super.onResume();
        loadSession();
    }
    public void loadSession(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/language.php?uname="+stn+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(zload.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());


                    }
                });

        queue.add(request);
    }
    public void setSessions(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();
                map.put("grade",obj.getString("grade"));
                map.put("language",obj.getString("language"));
                map.put("is_admin",obj.getString("is_admin"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.zlan;
            //2.views
            int[] views = {R.id.tvgrade, R.id.tvlanguage,R.id.tvisadmin};
            //3.Columms
            String[]  columns = {"grade","language","is_admin"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}