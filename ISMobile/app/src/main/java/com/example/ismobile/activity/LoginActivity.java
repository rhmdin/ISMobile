package com.example.ismobile.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismobile.api.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ismobile.R;
import com.example.ismobile.modelapi.LoginRequest;
import com.example.ismobile.modelapi.LoginResponse;
import com.example.ismobile.modelapi.LoginUser;

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
        tv_edit_usn = findViewById(R.id.login_edit_username);
        tv_edit_pw = findViewById(R.id.login_edit_password);
        usn = tv_edit_usn.getText().toString();
        pw = tv_edit_pw.getText().toString();

        //Log.d("salah", "login: " +usn);

        if(TextUtils.isEmpty(usn) || TextUtils.isEmpty(pw)){
            Toast.makeText(LoginActivity.this,"Username / Password tidak boleh kosong", Toast.LENGTH_LONG).show();
        }else{
            login();
            /*Intent login2main = new Intent(LoginActivity.this, MainActivity.class);
            login2main.putExtra("username", usn);
            Toast.makeText(LoginActivity.this, "Berhasil Login " + usn, Toast.LENGTH_SHORT).show();
            startActivity(login2main);*/
        }
    }


    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(usn);
        loginRequest.setPassword(pw);

        Call<LoginResponse> loginResponseCall = APIClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()){
                    LoginResponse loginResponse = response.body();
                    if (loginResponse.getStatus() != ""){
                        String token = loginResponse.getAuthorisation().getToken();
                        String name = loginResponse.getUser().getName();
                        String username = loginResponse.getUser().getUsername();
                        String eml = loginResponse.getUser().getEmail();
                        Log.i("success", token);
                        SharedPreferences sharedPreferences = getSharedPreferences("userkey", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("token", token);
                        editor.putString("name", name);
                        editor.putString("email", eml);
                        editor.putString("username", username);
                        Log.d("email", eml);
                        editor.apply();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Bundle extras = new Bundle();
                                Toast.makeText(LoginActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this,MainActivity.class).putExtras(extras));
                            }
                        },700);
                    }
                }else{
                    Toast.makeText(LoginActivity.this,"Login Failed", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }
}