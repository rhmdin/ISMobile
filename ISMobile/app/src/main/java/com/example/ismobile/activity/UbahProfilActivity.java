package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.widget.EditText;

import com.example.ismobile.R;
import com.example.ismobile.api.APIClient;
import com.example.ismobile.fragment.ProfileFragment;
import com.example.ismobile.modelapi.Profile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UbahProfilActivity extends AppCompatActivity{

    private EditText edit_nama, edit_nip, edit_email, edit_nohp;
    private String gettoken, token, name, email;

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

        SharedPreferences sharedPreferences = this.getSharedPreferences("userkey", Context.MODE_PRIVATE);
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
    }


    public void updateprofil(){

    }
}