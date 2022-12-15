package com.example.ismobile.activity;
import com.example.ismobile.R;
import com.example.ismobile.fragment.*;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    RequestFragment requestFragment = new RequestFragment();
    JadwalDosenFragment jadwaldosenFragment = new JadwalDosenFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    public TextView tv_usn;
    private String status, usn, statusinv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        Log.d("nama", "onCreate: " +usn);


        Bundle extrasmain = getIntent().getExtras();
        status = extrasmain.getString("status");
        statusinv = extrasmain.getString("status");
        usn = extrasmain.getString("username");

        if(status.equals("login") || statusinv.isEmpty()){
            Bundle bundlehome = new Bundle();
            bundlehome.putString("username", usn);
            homeFragment.setArguments(bundlehome);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
        }
        else if( statusinv.isEmpty()==false){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, jadwaldosenFragment).commit();
        }


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