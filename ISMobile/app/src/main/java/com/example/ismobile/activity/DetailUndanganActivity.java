package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ismobile.R;

public class DetailUndanganActivity extends AppCompatActivity {

    private TextView detail_kategori, detail_judul_kategori, detail_nama, detail_nim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_undangan);
        detail_kategori = findViewById(R.id.detailjadwal_kategori);
        detail_judul_kategori = findViewById(R.id.detailjadwal_judulkategori);

        Intent undangandetail = getIntent();
        String kategori = undangandetail.getStringExtra("undangan_kategori");
        detail_kategori.setText(kategori);
        detail_judul_kategori.setText("Detail "+kategori);
    }
}