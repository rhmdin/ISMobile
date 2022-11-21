package com.example.ismobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ismobile.R;

public class LoginActivity extends AppCompatActivity {

    TextView tv_edit_usn, tv_edit_pw;
    Button btn_login;
    String usn,pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClick_Button_Login(View view){
        tv_edit_usn = (EditText) findViewById(R.id.login_edit_username);
        usn = tv_edit_usn.getText().toString();

        Log.d("salah", "login: " +usn);

        if(usn!=null){
            Intent login2main = new Intent(LoginActivity.this, MainActivity.class);
            login2main.putExtra("username", usn);
            Toast.makeText(LoginActivity.this, "Berhasil Login" + usn, Toast.LENGTH_SHORT).show();
            startActivity(login2main);
        } else {
            Toast.makeText(LoginActivity.this, "Gagal Login", Toast.LENGTH_SHORT).show();
        }
    }
}