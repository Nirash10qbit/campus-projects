package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class analyse extends AppCompatActivity {

    String stn,sts,stm;
    TextView tv1,tv2;
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse);

        lv1 = findViewById(R.id.lvtotal);

        stn = getIntent().getExtras().getString("uname");

        tv1 = findViewById(R.id.nstn);
        sts = getIntent().getExtras().getString("tstn");
        tv1.setText(sts);

        tv2 = findViewById(R.id.nmarks);
        stm = getIntent().getExtras().getString("tmarks");
        tv2.setText(stm);
    }

    public void backanalyse(View view){
        Intent intent = new Intent(this,menus.class);
        intent.putExtra("uname", stn);
        startActivity(intent);
        finish();
    }
    protected void onResume(){
        super.onResume();
        loadSession1();
    }
    public void loadSession1(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url1 = "https://eschoolslgit1.000webhostapp.com/lab.php?";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url1, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions1(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(analyse.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());


                    }
                });

        queue.add(request);
    }
    public void setSessions1(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("tstn",obj.getString("tstn"));
                map.put("tmarks",obj.getString("tmarks"));
                map.put("ttotal",obj.getString("ttotal"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.zlabtotal;
            //2.views
            int[] views = {R.id.tvtstn,R.id.tvtmarks,R.id.tvtotal};
            //3.Columms
            String[]  columns = {"tstn","tmarks","ttotal"};
            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv1.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}