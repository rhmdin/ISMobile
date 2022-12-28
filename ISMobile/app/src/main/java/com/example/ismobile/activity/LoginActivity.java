package com.example.ismobile.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    EditText edit_usn, edit_pw;
    Button btn_login;
    String usn,pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClick_Button_Login(View view){
        edit_usn = findViewById(R.id.login_edit_username);
        edit_pw = findViewById(R.id.login_edit_password);
        usn = edit_usn.getText().toString();
        pw = edit_pw.getText().toString();

        //Log.d("salah", "login: " +usn);

            login();
    }


    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(usn);
        loginRequest.setPassword(pw);

        if(validation(usn, pw).equals(1)) {
            Call<LoginResponse> loginResponseCall = APIClient.getUserService().userLogin(loginRequest);
            loginResponseCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    String message;
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
                                    Intent login2main = new Intent(LoginActivity.this,MainActivity.class).putExtra("logx"," true");
                                    Toast.makeText(LoginActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(login2main);
                                }
                            },700);
                        }
                        else{
                            message = loginResponse.getStatus();
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
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

    public Integer validation(String usn, String password){
        Integer valid = 1;
        if(usn.isEmpty()){
            edit_usn.getBackground().setColorFilter(getResources().getColor(R.color.merah), PorterDuff.Mode.SRC_IN);
            edit_usn.setError("Masukkan NIP!");
            valid = 0;
        }
        else{
            edit_usn.getBackground().setColorFilter(getResources().getColor(R.color.abu_muda), PorterDuff.Mode.SRC_ATOP);
            if(pw.isEmpty()){
                edit_pw.getBackground().setColorFilter(getResources().getColor(R.color.merah), PorterDuff.Mode.SRC_ATOP);
                edit_pw.setError("Masukkan password!");
                valid = 0;
            }
            else{
                edit_pw.getBackground().setColorFilter(getResources().getColor(R.color.abu_muda), PorterDuff.Mode.SRC_ATOP);
            }
        }
        return valid;
    }

}