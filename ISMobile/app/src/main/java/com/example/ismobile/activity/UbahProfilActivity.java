package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ismobile.R;
import com.example.ismobile.api.APIClient;
import com.example.ismobile.fragment.ProfileFragment;
import com.example.ismobile.modelapi.ProfileResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UbahProfilActivity extends AppCompatActivity{

    private EditText tv_nama, tv_nip, tv_email, tv_nohp;
    private String gettoken, token, name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_profil);
        tv_nama = (EditText) findViewById(R.id.profil_edit_nama);
        tv_email = (EditText) findViewById(R.id.profile_edit_email);
        tv_nip = (EditText) findViewById(R.id.profil_edit_nip);
        KeyListener mKeyListener = tv_nip.getKeyListener();
        tv_nip.setKeyListener(null);
        getSupportFragmentManager().beginTransaction().add(R.id.profileFragment, new ProfileFragment());

        SharedPreferences sharedPreferences = this.getSharedPreferences("userkey", Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;


        Call<ProfileResponse> profileResponseCall = APIClient.getUserService().userProfile(token);
        profileResponseCall.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                ProfileResponse profileResponse = response.body();
                tv_nama.setText(profileResponse.getName());
                tv_nip.setText(profileResponse.getUsername());
                tv_email.setText(profileResponse.getEmail());
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {

            }
        });
    }


}