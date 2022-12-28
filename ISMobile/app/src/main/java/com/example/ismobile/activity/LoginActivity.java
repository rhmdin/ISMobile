package com.example.ismobile.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismobile.api.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ismobile.R;
import com.example.ismobile.modelapi.Login;

import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    EditText edit_usn, edit_pw;
    String usn, pw, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_login = findViewById(R.id.login_btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_usn = findViewById(R.id.login_edit_username);
                edit_pw = findViewById(R.id.login_edit_password);
                usn = edit_usn.getText().toString();
                pw = edit_pw.getText().toString();
                login();
            }
        });
    }

    public void login(){
           if(validation(usn, pw).equals(1)){

               Call<Login> call = APIClient.getUserService().userLogin(usn, pw);
               call.enqueue(new Callback<Login>() {
                   @Override
                   public void onResponse(Call<Login> call, Response<Login> response) {
                       Login login = response.body();
                       if(login.getStatus()!=""){
                           String token = login.getAuthorisation().getToken();
                           String name = login.getUser().getName();
                           String usn = login.getUser().getUsername();
                           String email = login.getUser().getEmail();

                           Log.i("success", token);
                           SharedPreferences sharedPreferences = getSharedPreferences("userkey", MODE_PRIVATE);
                           SharedPreferences.Editor editor = sharedPreferences.edit();
                           editor.putString("token", token);
                           editor.putString("username", usn);
                           editor.putString("name", name);
                           editor.putString("email", email);

                           Log.d("email", email);
                           editor.apply();

                           Intent login2main = new Intent(LoginActivity.this, MainActivity.class);
                           login2main.putExtra("logx", true);
                           startActivity(login2main);
                       }
                       else {
                           message = login.getStatus();
                           Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                       }

                   }

                   @Override
                   public void onFailure(Call<Login> call, Throwable t) {
                       Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                   }
               });
           }
    }

    public Integer validation(String usn, String pw){
        Integer valid = 1;
        if(usn.isEmpty()){
            edit_usn.getBackground().setColorFilter(getResources().getColor(R.color.merah), PorterDuff.Mode.SRC_IN);
            edit_usn.setError("Masukkan NIP!");
            valid = 0;
        }
        else{
            if(pw.isEmpty()){
                edit_pw.getBackground().setColorFilter(getResources().getColor(R.color.merah), PorterDuff.Mode.SRC_ATOP);
                edit_pw.setError("Masukkan password!");
                valid = 0;
            }
            else{

            }
        }
        return valid;
    }

}