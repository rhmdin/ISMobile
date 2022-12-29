package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ismobile.R;
import com.example.ismobile.api.APIClient;
import com.example.ismobile.fragment.ProfileFragment;
import com.example.ismobile.modelapi.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import kotlin.contracts.Returns;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UbahProfilActivity extends AppCompatActivity{

    private EditText edit_nama, edit_nip, edit_email, edit_nohp;
    private String gettoken, token, name, email, name2, email2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_profil);
        edit_nama = (EditText) findViewById(R.id.profil_edit_nama);
        edit_email = (EditText) findViewById(R.id.profile_edit_email);
        edit_nip = (EditText) findViewById(R.id.profil_edit_nip);
        KeyListener mKeyListener = edit_nip.getKeyListener();
        edit_nip.setKeyListener(null);
        getSupportFragmentManager().beginTransaction().add(R.id.profileFragment, new ProfileFragment());

        SharedPreferences sharedPreferences = this.getSharedPreferences("userkey", Context.MODE_PRIVATE);;
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;


        Call<Profile> profileResponseCall = APIClient.getUserService().userProfile(token);
        profileResponseCall.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                Profile profileResponse = response.body();
                edit_nama.setText(profileResponse.getName());
                edit_nip.setText(profileResponse.getUsername());
                edit_email.setText(profileResponse.getEmail());
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });

        ImageButton submitedit = findViewById(R.id.profile_Edit_submit);
        submitedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name2 = edit_nama.getText().toString();
                email2 = edit_email.getText().toString();

                Call<UpdateProfile> call = APIClient.getUserService().userProfileEdit(token, email2, name2);
                call.enqueue(new Callback<UpdateProfile>() {
                    @Override
                    public void onResponse(Call<UpdateProfile> call, Response<UpdateProfile> response) {
                        UpdateProfile updateProfile = response.body();
                        String message;
                        JSONObject jsonObject = null;
                        Log.d("status", updateProfile.getMessage());
                        if (response.code() == 200){
                            if (response.isSuccessful()) {
                                message = response.body().getMessage();
                                Toast.makeText(UbahProfilActivity.this, message, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(UbahProfilActivity.this, MainActivity.class);
                                setResult(RESULT_OK, intent);
                                startActivity(intent);
                            }
                        }
                        else if(response.code() == 403){
                            if(!response.isSuccessful()){
                                try {
                                    jsonObject = new JSONObject(response.errorBody().string());
                                    message = jsonObject.getString("message");
                                } catch (JSONException | IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        else{
                            message = updateProfile.getMessage();
                            Toast.makeText(UbahProfilActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UpdateProfile> call, Throwable t) {

                    }
                });
            }
        });
    }


    /*public void update(View view){
        name2 = edit_nama.getText().toString();
        email2 = edit_email.getText().toString();

        SharedPreferences sharedPreferences = this.getSharedPreferences("userkey", Context.MODE_PRIVATE);;
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;
        Log.d("token1", token);
        Call<UpdateProfile> call = APIClient.getUserService().userProfileEdit(token, name, email);
        call.enqueue(new Callback<UpdateProfile>() {
            @Override
            public void onResponse(Call<UpdateProfile> call, Response<UpdateProfile> response) {
                UpdateProfile updateProfile = response.body();
                String message;
                JSONObject jsonObject = null;
                Log.d("status", updateProfile.getMessage());
                if (response.code() == 200){
                    if (response.isSuccessful()) {
                        message = response.body().getMessage();
                        Toast.makeText(UbahProfilActivity.this, name2, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UbahProfilActivity.this, MainActivity.class);
                        intent.putExtra("name", name);
                        setResult(RESULT_OK, intent);
                        startActivity(intent);
                        finish();
                    }
                }
                else if(response.code() == 403){
                    if(!response.isSuccessful()){
                        try {
                            jsonObject = new JSONObject(response.errorBody().string());
                            message = jsonObject.getString("message");
                        } catch (JSONException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    message = updateProfile.getMessage();
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UpdateProfile> call, Throwable t) {

            }
        });
    }*/
    /*public void updateprofil(){
        name2 = edit_nama.getText().toString();
        email2 = edit_email.getText().toString();

        Call<UpdateProfile> call = APIClient.getUserService().userProfileEdit(token, name, email);
        call.enqueue(new Callback<UpdateProfile>() {
            @Override
            public void onResponse(Call<UpdateProfile> call, Response<UpdateProfile> response) {
                UpdateProfile updateProfile = response.body();
                String message;
                JSONObject jsonObject = null;
                Log.d("status", updateProfile.getMessage());
                if (response.code() == 200){
                    if (response.isSuccessful()) {
                        message = response.body().getMessage();
                        Toast.makeText(UbahProfilActivity.this, message, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UbahProfilActivity.this, MainActivity.class);
                        intent.putExtra("name", name);
                        setResult(RESULT_OK, intent);
                        startActivity(intent);
                    }
                }
                else if(response.code() == 403){
                    if(!response.isSuccessful()){
                        try {
                            jsonObject = new JSONObject(response.errorBody().string());
                            message = jsonObject.getString("message");
                        } catch (JSONException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    message = updateProfile.getMessage();
                    Toast.makeText(UbahProfilActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UpdateProfile> call, Throwable t) {

            }
        });
    }*/
}