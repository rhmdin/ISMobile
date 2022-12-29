package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ismobile.R;
import com.example.ismobile.api.APIClient;
import com.example.ismobile.modelapi.ChangePassword;
import com.example.ismobile.modelapi.Profile;
import com.example.ismobile.modelapi.UpdateProfile;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UbahPasswordActivity extends AppCompatActivity {

    private EditText editpw_old, editpw_new, editpw_confirm;
    private String pw_old, pw_new, pw_confirm, gettoken, token, status, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_password);

        editpw_old = (EditText) findViewById(R.id.editpw_old);
        editpw_new = (EditText) findViewById(R.id.editpw_new);
        editpw_confirm = (EditText) findViewById(R.id.editpw_confirm);

        pw_old = editpw_old.getText().toString();
        pw_new = editpw_new.getText().toString();
        pw_confirm = editpw_confirm.getText().toString();
        SharedPreferences sharedPreferences = this.getSharedPreferences("userkey", Context.MODE_PRIVATE);;
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;


        ImageButton editpw_submit = findViewById(R.id.editpw_submit);
        editpw_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editpw_new.getText().toString().isEmpty()){
                    Toast.makeText(UbahPasswordActivity.this,"pw nya gak kedetek"+pw_new,Toast.LENGTH_SHORT).show();
                }
                else {
                    if(TextUtils.equals(editpw_new.getText().toString(),editpw_confirm.getText().toString())){
                        Call<ChangePassword> changePasswordCall = APIClient.getUserService().changePassword(token, pw_old, pw_new, pw_confirm);
                        changePasswordCall.enqueue(new Callback<ChangePassword>() {
                            @Override
                            public void onResponse(Call<ChangePassword> call, Response<ChangePassword> response) {
                                ChangePassword changePassword = response.body();
                                status = changePassword.getStatus();
                                msg = changePassword.getMessage();
                                JSONObject jsonObject = null;
                                Log.d("status", status);
                                if (response.code() == 200){
                                    if (response.isSuccessful()) {
                                        Toast.makeText(UbahPasswordActivity.this, msg, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(UbahPasswordActivity.this, MainActivity.class);
                                        setResult(RESULT_OK, intent);
                                        startActivity(intent);
                                    }
                                }
                                else if(response.code() == 403){
                                    if(!response.isSuccessful()){
                                        try {
                                            jsonObject = new JSONObject(response.errorBody().string());
                                            msg = jsonObject.getString("message");
                                        } catch (JSONException | IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(UbahPasswordActivity.this, msg, Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ChangePassword> call, Throwable t) {

                            }
                        });
                    }
                    else{
                        Toast.makeText(UbahPasswordActivity.this,"Masukkan kembali password "+editpw_new.getText().toString()+" "+editpw_confirm.getText().toString(),Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}