package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zlabgamef extends AppCompatActivity {

    String st,st0,st1,st2,st3,st4,st5,st6,st8,st9,st10,stn,stl,stg,sta,stb,stz,stqa,stqb,stqc,stqd,stqe,staa,stab,stac,stad,stae,totale,totalf,ra,rb,rc,rd,re,sttstn,sttmarks,stnt,totalt,markst,sttotal,tote,tstn,tmarks,ttotal,atstn,atmarks,attotal;
    TextView tv2,tv3,tv4,tv5;
    ListView lv1;
    Button etadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlabgamef);

        etadd = findViewById(R.id.radds1);

        stn = getIntent().getExtras().getString("uname");
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

        st = getIntent().getExtras().getString("value");
        st1= getIntent().getExtras().getString("gid");

        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");
        st4 = getIntent().getExtras().getString("CIDNAME");
        st5 = getIntent().getExtras().getString("CID");

        st6 = getIntent().getExtras().getString("CPDF");
        st0 = getIntent().getExtras().getString("SIDPDF");
        sta = getIntent().getExtras().getString("aid");
        stb = getIntent().getExtras().getString("bid");
        stz = getIntent().getExtras().getString("zid");
        stqa = getIntent().getExtras().getString("zqa");
        stqb = getIntent().getExtras().getString("zqb");
        stqc = getIntent().getExtras().getString("zqc");
        stqd = getIntent().getExtras().getString("zqd");
        stqe = getIntent().getExtras().getString("zqe");
        staa = getIntent().getExtras().getString("zaa");
        stab = getIntent().getExtras().getString("zab");
        stac = getIntent().getExtras().getString("zac");
        stad = getIntent().getExtras().getString("zad");
        stae = getIntent().getExtras().getString("zae");


        ra = getIntent().getExtras().getString("ra");
        rb = getIntent().getExtras().getString("rb");
        rc = getIntent().getExtras().getString("rc");
        rd = getIntent().getExtras().getString("rd");
        re = getIntent().getExtras().getString("re");


        tv2 = findViewById(R.id.gidnew6);
        totale = getIntent().getExtras().getString("totale");
        tv2.setText(totale);

        lv1 = findViewById(R.id.lv3);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                tv3 = findViewById(R.id.tvtstn);
                sttstn = tv3.getText().toString();

                tv4 = view.findViewById(R.id.tvtmarks);
                sttmarks = tv4.getText().toString();

                tv5 = view.findViewById(R.id.tvtotal);
                sttotal = tv5.getText().toString();

                tote = String.valueOf(totale);
                int tot = Integer.valueOf(tote);

                int tnstn = Integer.valueOf(sttstn);
                int nstn = tnstn + 1;
                stnt = String.valueOf(nstn);

                int tnmarks = Integer.valueOf(sttmarks);
                int nmarks = tnmarks + tot;
                markst = String.valueOf(nmarks);

                int nstotal = nmarks/nstn;
                totalt = String.valueOf(nstotal);

                addclasses(stnt,markst,totalt,stn,stg,st1,sta,stb,stz);

            }
        });

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                tv3 = findViewById(R.id.tvtstn);
                sttstn = tv3.getText().toString();

                tv4 = view.findViewById(R.id.tvtmarks);
                sttmarks = tv4.getText().toString();

                tv5 = view.findViewById(R.id.tvtotal);
                sttotal = tv5.getText().toString();

                tote = String.valueOf(totale);
                int tot = Integer.valueOf(tote);

                int tnstn = Integer.valueOf(sttstn);
                int nstn = tnstn + 1;
                stnt = String.valueOf(nstn);

                int tnmarks = Integer.valueOf(sttmarks);
                int nmarks = tnmarks + tot;
                markst = String.valueOf(nmarks);

                int nstotal = nmarks/nstn;
                totalt = String.valueOf(nstotal);

                addclasses(stnt,markst,totalt,stn,stg,st1,sta,stb,stz);

            }
        });

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
                        Toast.makeText(zlabgamef.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
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
            int layout= R.layout.zlabt;
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

    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



    private void addclasses( final String stnt, final String markst, final  String totalt,final String stn, final String stg, final  String st1 ,final  String sta, final String stb, final String stz) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updatedata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    Toast.makeText(zlabgamef.this, " Successfully Access data", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(zlabgamef.this, zlabgamef.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    intent.putExtra("value", st);
                    intent.putExtra("gid", st1);
                    intent.putExtra("SIDNAME", st2);
                    intent.putExtra("SID", st3);
                    intent.putExtra("SIDPDF", st0);
                    intent.putExtra("CID", st4);
                    intent.putExtra("CIDNAME", st5);
                    intent.putExtra("CPDF", st6);
                    intent.putExtra("aid", sta);
                    intent.putExtra("bid", stb);
                    intent.putExtra("zid", stz);
                    intent.putExtra("zqa", stqa);
                    intent.putExtra("zqb", stqb);
                    intent.putExtra("zqc", stqc);
                    intent.putExtra("zqd", stqd);
                    intent.putExtra("zqe", stqe);
                    intent.putExtra("zaa", staa);
                    intent.putExtra("zab", stab);
                    intent.putExtra("zac", stac);
                    intent.putExtra("zad", stad);
                    intent.putExtra("zae", stae);
                    intent.putExtra("ra", ra);
                    intent.putExtra("rb", rb);
                    intent.putExtra("rc", rc);
                    intent.putExtra("rd", rd);
                    intent.putExtra("re", re);
                    startActivity(intent);

                } else {
                    Toast.makeText(zlabgamef.this, "Error", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(zlabgamef.this, zlabgamef.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    intent.putExtra("value", st);
                    intent.putExtra("gid", st1);
                    intent.putExtra("SIDNAME", st2);
                    intent.putExtra("SID", st3);
                    intent.putExtra("SIDPDF", st0);
                    intent.putExtra("CID", st4);
                    intent.putExtra("CIDNAME", st5);
                    intent.putExtra("CPDF", st6);
                    intent.putExtra("aid", sta);
                    intent.putExtra("bid", stb);
                    intent.putExtra("zid", stz);
                    intent.putExtra("zqa", stqa);
                    intent.putExtra("zqb", stqb);
                    intent.putExtra("zqc", stqc);
                    intent.putExtra("zqd", stqd);
                    intent.putExtra("zqe", stqe);
                    intent.putExtra("zaa", staa);
                    intent.putExtra("zab", stab);
                    intent.putExtra("zac", stac);
                    intent.putExtra("zad", stad);
                    intent.putExtra("zae", stae);
                    intent.putExtra("ra", ra);
                    intent.putExtra("rb", rb);
                    intent.putExtra("rc", rc);
                    intent.putExtra("rd", rd);
                    intent.putExtra("re", re);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(zlabgamef.this, "Please check your Internet Connection", Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                Intent intent = new Intent(zlabgamef.this, zlabgamef.class);
                intent.putExtra("uname", stn);
                intent.putExtra("language", stl);
                intent.putExtra("grade", stg);
                intent.putExtra("value", st);
                intent.putExtra("gid", st1);
                intent.putExtra("SIDNAME", st2);
                intent.putExtra("SID", st3);
                intent.putExtra("SIDPDF", st0);
                intent.putExtra("CID", st4);
                intent.putExtra("CIDNAME", st5);
                intent.putExtra("CPDF", st6);
                intent.putExtra("aid", sta);
                intent.putExtra("bid", stb);
                intent.putExtra("zid", stz);
                intent.putExtra("zqa", stqa);
                intent.putExtra("zqb", stqb);
                intent.putExtra("zqc", stqc);
                intent.putExtra("zqd", stqd);
                intent.putExtra("zqe", stqe);
                intent.putExtra("zaa", staa);
                intent.putExtra("zab", stab);
                intent.putExtra("zac", stac);
                intent.putExtra("zad", stad);
                intent.putExtra("zae", stae);
                intent.putExtra("ra", ra);
                intent.putExtra("rb", rb);
                intent.putExtra("rc", rc);
                intent.putExtra("rd", rd);
                intent.putExtra("re", re);
                startActivity(intent);

            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("tstn", stnt);
                params.put("tmarks", markst);
                params.put("ttotal", totalt);
                params.put("stn", stn);
                params.put("stg", stg);
                params.put("st1", st1);
                params.put("sta", sta);
                params.put("stb", stb);
                params.put("stz", stz);

                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}
