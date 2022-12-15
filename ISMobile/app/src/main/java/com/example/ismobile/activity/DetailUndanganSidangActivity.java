package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ismobile.R;

public class DetailUndanganSidangActivity extends AppCompatActivity {

    Button inputnilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_undangan_sidang);

        inputnilai = (Button) findViewById(R.id.sidang_btn_feedback);
        inputnilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedback = new Intent(DetailUndanganSidangActivity.this, InputNilaiActivity.class);
                startActivity(feedback);
            };
        });
    }
}