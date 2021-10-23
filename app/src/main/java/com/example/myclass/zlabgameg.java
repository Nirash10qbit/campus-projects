package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class zlabgameg extends AppCompatActivity {

    String st,st0,st1,st2,st3,st4,st5,st6,st8,st9,st10,stn,stl,stg,sta,stb,stz,stqa,stqb,stqc,stqd,stqe,staa,stab,stac,stad,stae,totale,ra,rb,rc,rd,re,sttstn,sttmarks,sttotal;
    TextView tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlabgameg);

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
        totale = getIntent().getExtras().getString("totale");


        tv2 = findViewById(R.id.stn);
        sttstn = getIntent().getExtras().getString("tstn");
        tv2.setText(sttstn);

        tv3 = findViewById(R.id.marks);
        sttmarks = getIntent().getExtras().getString("tmarks");
        tv3.setText(sttmarks);

        tv4 = findViewById(R.id.total);
        sttotal = getIntent().getExtras().getString("ttotal");
        tv4.setText(sttotal);

    }

    public void nextanswer(View view){
        Intent intent = new Intent(this,zlabgameh.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SID",st3);
        intent.putExtra("SIDPDF",st0);
        intent.putExtra("CID",st5);
        intent.putExtra("CIDNAME",st4);
        intent.putExtra("CPDF",st6);
        intent.putExtra("aid",sta);
        intent.putExtra("bid",stb);
        intent.putExtra("zid",stz);
        intent.putExtra("zqa",stqa);
        intent.putExtra("zqb",stqb);
        intent.putExtra("zqc",stqc);
        intent.putExtra("zqd",stqd);
        intent.putExtra("zqe",stqe);
        intent.putExtra("zaa",staa);
        intent.putExtra("zab",stab);
        intent.putExtra("zac",stac);
        intent.putExtra("zad",stad);
        intent.putExtra("zae",stae);
        intent.putExtra("zma", st8);
        intent.putExtra("totale", totale);
        intent.putExtra("ra", ra);
        intent.putExtra("rb", rb);
        intent.putExtra("rc", rc);
        intent.putExtra("rd", rd);
        intent.putExtra("re", re);
        intent.putExtra("tstn",sttstn);
        intent.putExtra("tmarks",sttmarks);
        startActivity (intent);
    }
}