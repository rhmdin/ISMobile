package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        Button btn_acc = (Button) findViewById(R.id.detailjadwal_btn_acc);
        Intent feedbacksemhas = new Intent(DetailUndanganActivity.this, DetailUndanganSeminarActivity.class);
        Intent feedbacksidang = new Intent(DetailUndanganActivity.this, DetailUndanganSidangActivity.class);
        btn_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int b =1;
                String a = kategori;
                Toast.makeText(DetailUndanganActivity.this, kategori, Toast.LENGTH_SHORT).show();
                if(a == "Seminar Hasil"){
                    startActivity(feedbacksemhas);
                }
                else if(a == "Sidang TA"){
                    startActivity(feedbacksidang);
                }
            };

    });
    }
}