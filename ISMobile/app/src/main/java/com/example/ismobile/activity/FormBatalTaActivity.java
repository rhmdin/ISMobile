package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ismobile.R;

public class FormBatalTaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_batal_ta);
    }

    public static class DetailTaMhsActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail_ta_mhs);
        }
    }
}