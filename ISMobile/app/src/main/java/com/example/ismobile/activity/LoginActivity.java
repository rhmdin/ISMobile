package com.example.ismobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ismobile.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
        tv_edit_pw = (EditText) findViewById(R.id.login_edit_password);
        usn = tv_edit_usn.getText().toString();
        pw = tv_edit_pw.getText().toString();

        //Log.d("salah", "login: " +usn);

        if(TextUtils.isEmpty(usn) || TextUtils.isEmpty(pw)){
            Toast.makeText(LoginActivity.this,"Username / Password tidak boleh kosong", Toast.LENGTH_LONG).show();
        }else{
            //proceed to login
            //login();
            Intent login2main = new Intent(LoginActivity.this, MainActivity.class);
            login2main.putExtra("username", usn);
            Toast.makeText(LoginActivity.this, "Berhasil Login" + usn, Toast.LENGTH_SHORT).show();
            startActivity(login2main);
        }
    }


    /*public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Login Successful", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            startActivity(new Intent(MainActivity.this,DashboardActivity.class).putExtra("data",loginResponse.getUsername()));
                        }
                    },700);

                }else{
                    Toast.makeText(MainActivity.this,"Login Failed", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }*/
}