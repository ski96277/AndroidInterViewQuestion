package com.example.imransk.androidinterviewquestion;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FrontPage extends AppCompatActivity implements View.OnClickListener {
    Button bsimple, btough, bseeotherapps, brateapp;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);

        //Code Add to Actionbar
        LinearLayout fontPage_ll = (LinearLayout)findViewById(R.id.frontpage_title_bar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.frontpage_title_bar);



        bsimple = (Button) findViewById(R.id.bsq);
        btough = (Button) findViewById(R.id.btq);
        bseeotherapps = (Button) findViewById(R.id.bseeotherapps);
        brateapp = (Button) findViewById(R.id.brateapp);

        bsimple.setOnClickListener(this);
        btough.setOnClickListener(this);
        bseeotherapps.setOnClickListener(this);
        brateapp.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bsq:
                Intent i = new Intent(FrontPage.this,simple_question.class);
                startActivity(i);
                break;
            case R.id.btq:
                Intent j = new Intent(FrontPage.this,Tough_Question.class);
                startActivity(j);
                break;
            case R.id.bseeotherapps:
                Toast.makeText(getApplicationContext(),"upcoming our more apps",Toast.LENGTH_SHORT).show();
//Account name is not Avale able now

                try{
 /// If play store is avable abale
                    Uri uriObj = Uri.parse("Market://Search?q = account name");
                    Intent gotoPlaystore = new Intent(Intent.ACTION_VIEW,uriObj);
                    startActivity(gotoPlaystore);
                }catch (ActivityNotFoundException e){
/// If play store is not avable abale
                    Uri uriObj = Uri.parse("http://play.google.com/store/Search?q = account name");
                    Intent gotoplaystore = new Intent(Intent.ACTION_VIEW,uriObj);
                    startActivity(gotoplaystore);
                }
                break;

            case R.id.brateapp:
                Toast.makeText(getApplicationContext(),"upcoming on Play store",Toast.LENGTH_SHORT).show();
                try{
                    Uri uriObj = Uri.parse("Market://details?id = "+getPackageName());
                    Intent gotoPlaystore = new Intent(Intent.ACTION_VIEW,uriObj);
                    startActivity(gotoPlaystore);
                }catch (ActivityNotFoundException e){
                    Uri uriObj = Uri.parse("http://play.google.com/store/apps/details?id = "+getPackageName());
                    Intent gotoplaystore = new Intent(Intent.ACTION_VIEW,uriObj);
                    startActivity(gotoplaystore);
                }
                break;


        }
    }
    // User conformation to exit

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure to exit this ??");
        dialog.setCancelable(false);
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                FrontPage.super.onBackPressed();
                finish();
            }
        });
        dialog.setNegativeButton("NO", null);
        dialog.create();
        dialog.show();
    }

}
