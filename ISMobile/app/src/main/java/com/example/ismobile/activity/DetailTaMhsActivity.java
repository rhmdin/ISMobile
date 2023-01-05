package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismobile.R;
import com.example.ismobile.api.APIClient;
import com.example.ismobile.modelapi.DetailTAMahasiswa;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTaMhsActivity extends AppCompatActivity {

    private Button nilai, fileta;
    private ImageButton ta2profil;
    private TextView tv_nama, tv_nim, tv_sejak, tv_pembimbing, tv_topik, tv_judul, tv_abstrak,tv_nilai;
    private String nama, token, gettoken, tgl, waktu, sejak;
    private int idtesis;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv_abstrak = findViewById(R.id.detailta_abstrak2);
        tv_judul = findViewById(R.id.detailta_judul2);
        tv_nama = findViewById(R.id.detailta_nama);
        tv_nim = findViewById(R.id.detailta_nim);
        tv_sejak = findViewById(R.id.detailta_start2);
        tv_nilai = findViewById(R.id.detailta_nilai2);
        tv_pembimbing = findViewById(R.id.detailta_supervisors2);
        tv_topik = findViewById(R.id.detailta_topik2);

        setContentView(R.layout.activity_detail_ta_mhs);
        Bundle bundle = getIntent().getExtras();
        int idtesis = bundle.getInt("idtesis");

        sharedPreferences = getSharedPreferences("userkey", Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;
        Toast.makeText(DetailTaMhsActivity.this, "idtesisnya: "+idtesis+" tokennya: "+token, Toast.LENGTH_SHORT).show();

        Call<DetailTAMahasiswa> detailTAMahasiswaCall = APIClient.getUserService().detailTAMhs(token, idtesis);
        detailTAMahasiswaCall.enqueue(new Callback<DetailTAMahasiswa>() {
            @Override
            public void onResponse(Call<DetailTAMahasiswa> call, Response<DetailTAMahasiswa> response) {
                DetailTAMahasiswa detailTAMahasiswa = response.body();
                if(response.code()==200){
                    tv_nama.setText(detailTAMahasiswa.getStudent().getName());
                    tv_nim.setText(detailTAMahasiswa.getStudent().getNim());
                    /*
                    if (!detailTAMahasiswa.getAbstrak().isEmpty() || !detailTAMahasiswa.getAbstrak().equals("")){
                        tv_abstrak.setText(detailTAMahasiswa.getAbstrak());
                    }
                    if(!detailTAMahasiswa.getTitle().isEmpty()||!detailTAMahasiswa.getTitle().equals("")){
                        tv_judul.setText(detailTAMahasiswa.getTitle());
                    }
                    if(!detailTAMahasiswa.getGrade().isEmpty()||!detailTAMahasiswa.getGrade().equals("")){
                        tv_nilai.setText(detailTAMahasiswa.getGrade());
                    }
                    if(!detailTAMahasiswa.getStartAt().isEmpty()||!detailTAMahasiswa.getStartAt().equals("")){
                        tv_sejak.setText(detailTAMahasiswa.getStartAt());
                    }
                    if(detailTAMahasiswa.getTopicId()!=0){
                        tv_topik.setText("(topik dengan id "+detailTAMahasiswa.getTopicId()+")");
                    }*/

                }
                else {
                    Toast.makeText(DetailTaMhsActivity.this, "Gagal tampil datanya", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<DetailTAMahasiswa> call, Throwable t) {

                Toast.makeText(DetailTaMhsActivity.this, "Lagi offline, gak kepanggil apinya", Toast.LENGTH_SHORT).show();

            }
        });
    }
}