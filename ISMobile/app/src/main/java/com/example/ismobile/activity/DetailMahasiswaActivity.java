package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ismobile.R;

public class DetailMahasiswaActivity extends AppCompatActivity {

    private TextView detailmhs_nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        detailmhs_nama = findViewById(R.id.detailmhs_nama);

        Intent bimbingandetail = getIntent();
        String nama = bimbingandetail.getStringExtra("bimbingan_nama");
        detailmhs_nama.setText(nama);
    }
}