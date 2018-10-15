package com.example.imransk.androidinterviewquestion;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Splash_Screen extends AppCompatActivity {
private static int splash_time_out = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(Splash_Screen.this,FrontPage.class);
                startActivity(welcome);
                finish();
            }
        },splash_time_out);
    }
}
