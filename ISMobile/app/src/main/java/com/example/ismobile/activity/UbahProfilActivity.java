package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.KeyListener;
import android.widget.TextView;

import com.example.ismobile.R;
import com.example.ismobile.fragment.ProfileFragment;

public class UbahProfilActivity extends AppCompatActivity{

    private TextView tv_nama, tv_nip, tv_email, tv_nohp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_profil);
        tv_nip = (TextView) findViewById(R.id.profil_edit_nip);
        KeyListener mKeyListener = tv_nip.getKeyListener();
        tv_nip.setKeyListener(null);
        getSupportFragmentManager().beginTransaction().add(R.id.profileFragment, new ProfileFragment());
    }


}