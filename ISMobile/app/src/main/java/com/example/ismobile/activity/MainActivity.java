package com.example.ismobile.activity;
import com.example.ismobile.R;
import com.example.ismobile.fragment.*;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    RequestFragment requestFragment = new RequestFragment();
    JadwalDosenFragment jadwaldosenFragment = new JadwalDosenFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    public TextView tv_usn;
    Boolean isLoggedIn;
    String nama, token, username, email;


    public void lihat (View view){
        Intent listbimbingan = new Intent(MainActivity. this,LogbookActivity.class);
        startActivity(listbimbingan);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        SharedPreferences sharedPreferences = getSharedPreferences(
                "userkey",
                MODE_PRIVATE
        );
        nama = sharedPreferences.getString("name", "Dosen");
        username = sharedPreferences.getString("username", "123");
        email = sharedPreferences.getString("email", "email");

        token = sharedPreferences.getString("token","");
        Log.d("token", token);
        if (token.equals("")){
            Log.i("token", token);
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }

         getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
                        return true;
                    case R.id.requestFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, requestFragment).commit();
                        return true;
                    case R.id.jadwaldosenFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, jadwaldosenFragment).commit();
                        return true;
                    case R.id.profileFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, profileFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}