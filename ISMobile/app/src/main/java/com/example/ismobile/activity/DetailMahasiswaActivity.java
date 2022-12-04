package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismobile.R;

public class DetailMahasiswaActivity extends AppCompatActivity {

    private TextView detailmhs_nama;
    private TextView tv_nama;
    private ImageButton logbook, nilai, cancel;
    private String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        detailmhs_nama = findViewById(R.id.detailmhs_nama);

        Intent bimbingandetail = getIntent();
        String nama = bimbingandetail.getStringExtra("bimbingan_nama");
        detailmhs_nama.setText(nama);
    }

    public void onclick_imgbtn_logbook(View view){
        tv_nama = (TextView) findViewById(R.id.detailmhs_nama);
        nama = tv_nama.getText().toString();

        Log.d("usn", "login: " +nama);

        if(nama!=null){
            Intent mhslogbook = new Intent(DetailMahasiswaActivity.this, LogbookActivity.class);
            mhslogbook.putExtra("username", nama);
            Toast.makeText(DetailMahasiswaActivity.this, "Buka Logbook " + nama, Toast.LENGTH_SHORT).show();
            startActivity(mhslogbook);
        } else {
            Toast.makeText(DetailMahasiswaActivity.this, "Gagal Buka Logbook", Toast.LENGTH_SHORT).show();
        }
    }
}