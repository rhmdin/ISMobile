package com.example.ismobile.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ismobile.R;

public class SplashScreenActivity extends AppCompatActivity {
    private String usn,gettoken,token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        SharedPreferences sharedPreferences = SplashScreenActivity.this.getSharedPreferences("userkey",  Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if( gettoken != null)
                {
                    startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
                }else
                {
                    startActivity(new Intent(SplashScreenActivity.this,LoginActivity.class));
                }
                finish();
            }
        }, 2000);
    }
}
