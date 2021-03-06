package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menue extends AppCompatActivity {

    String st,st1,stn;
    DrawerLayout drawerLayouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menue);

        drawerLayouts = findViewById(R.id.drawer_layer_admin);

        stn = getIntent().getExtras().getString("uname");
    }
    public void ClickMenuAdmin(View view){
        openDrawer(drawerLayouts);
    }

    private void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void DashboardAdmin(View view) {
        Intent intent = new Intent (this,menus.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }
    public void AnalyseAdmin(View view){
        Intent intent = new Intent (this,analyse.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }
    public void SettingsAdmin(View view) {
        Intent intent = new Intent (this,adminsettings.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }
    public void LogoutAdmin(View view){
        logout(this);
    }


    private void logout(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void esbtn(View view){
        Intent intent = new Intent (this,menus.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }

    public void etbtn(View view){
        Intent intent = new Intent (this,menut.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }

    public void eebtn(View view){
        Intent intent = new Intent (this,menue.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }

    public void ea(View view){

        st = "Grade 01";
        st1="eg001";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }

    public void eb(View view){

        st = "Grade 02";
        st1="eg002";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void ec(View view){

        st = "Grade 03";
        st1="eg003";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void ed(View view){

        st = "Grade 04";
        st1="eg004";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void ee(View view){

        st = "Grade 05";
        st1="eg005";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void ef(View view){

        st = "Grade 06";
        st1="eg6";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void eg(View view){

        st = "Grade 07";
        st1="eg7";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void eh(View view){

        st = "Grade 08";
        st1="eg08";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void ei(View view){

        st = "Grade 09";
        st1="eg09";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void ej(View view){

        st = "Grade 10";
        st1="eg10";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void ek(View view){

        st = "Grade 11";
        st1="eg11";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void el(View view){

        st = "Subject";
        st1="eg12";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }

}
