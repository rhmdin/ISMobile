package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ismobile.R;
import com.example.ismobile.fragment.ProfileFragment;

public class UbahProfilActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_profil);

        getSupportFragmentManager().beginTransaction().add(R.id.profileFragment, new ProfileFragment());
    }


}