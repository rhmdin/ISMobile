package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ismobile.R;

public class DetailUndanganSeminarActivity extends AppCompatActivity {

    Button rekomen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_undangan_seminar);

        rekomen = (Button) findViewById(R.id.semhas_btn_feedback);
        rekomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedback = new Intent(DetailUndanganSeminarActivity.this, DetailUndanganSeminarFeedbackActivity.class);
                startActivity(feedback);
            };
        });

    }
}