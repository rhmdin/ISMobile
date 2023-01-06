package com.example.ismobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismobile.R;
import com.example.ismobile.api.APIClient;
import com.example.ismobile.modelapi.DetailTAMahasiswa;
import com.example.ismobile.modelapi.Examiners;
import com.example.ismobile.modelapi.Seminars;
import com.example.ismobile.modelapi.Supervisors;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTaMhsActivity extends AppCompatActivity {

    Button nilai, fileta;
    TextView tv_nama, tv_nim, tv_sejak, tv_pembimbing, tv_topik, tv_judul, tv_abstrak,tv_nilai;
    String nama, token, gettoken, tgl, waktu, sejak, pembimbing2, usn;
    int idtesis;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ta_mhs);

        tv_nama = findViewById(R.id.detailta_nama);
        tv_nim = findViewById(R.id.detailta_nim);
        tv_abstrak = findViewById(R.id.detailta_abstrak2);
        tv_judul = findViewById(R.id.detailta_judul2);
        tv_sejak = findViewById(R.id.detailta_start2);
        tv_nilai = findViewById(R.id.detailta_nilai2);
        tv_pembimbing = findViewById(R.id.detailta_supervisors2);
        tv_topik = findViewById(R.id.detailta_topik2);

        Bundle bundle = getIntent().getExtras();
        int idtesis = bundle.getInt("idtesis");

        sharedPreferences = getSharedPreferences("userkey", Context.MODE_PRIVATE);
        usn = sharedPreferences.getString("username", "");

        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;
        Toast.makeText(DetailTaMhsActivity.this, "idtesisnya: "+idtesis+" usn: "+usn, Toast.LENGTH_SHORT).show();
        tv_nama.setText("Bismillah");

        Call<DetailTAMahasiswa> calldetailta = APIClient.getUserService().detailTAMhs(token, idtesis);
        calldetailta.enqueue(new Callback<DetailTAMahasiswa>() {
            @Override
            public void onResponse(Call<DetailTAMahasiswa> call, Response<DetailTAMahasiswa> response) {
                DetailTAMahasiswa detailTAMahasiswa = response.body();
                if(response.code()==200){
                    tv_nama.setText(detailTAMahasiswa.getStudent().getName());
                    tv_nim.setText(detailTAMahasiswa.getStudent().getNim());
                    String tgl = Instant.parse(detailTAMahasiswa.getStartAt())                // Parse this String in standard ISO 8601 format as a `Instant`, a point on the timeline in UTC. The `Z` means UTC.
                            .atOffset( ZoneOffset.UTC )                                // Change from `Instant` to the more flexible `OffsetDateTime`.
                            .format(                                                   // Generate a String representing the value of this `OffsetDateTime` object.
                                    DateTimeFormatter.ofPattern( "dd/MM/uuuu hh:mm:ss" )   // Specify a formatting pattern as desired.
                            );
                    tv_sejak.setText(tgl);
                    tv_topik.setText("Topik dengan id "+detailTAMahasiswa.getTopicId());
                    tv_judul.setText(detailTAMahasiswa.getTitle());
                    tv_abstrak.setText(detailTAMahasiswa.getAbstrak());
                    tv_nilai.setText(detailTAMahasiswa.getGrade());
                    sharedPreferences = getSharedPreferences("userkey", Context.MODE_PRIVATE);
                    usn = sharedPreferences.getString("username", "");


                    List<Supervisors> listpembimbing = detailTAMahasiswa.getSupervisors();
                    if (!listpembimbing.isEmpty()||!listpembimbing.contains(null)){
                        for(Supervisors itempembimbing: listpembimbing){
                            if(!itempembimbing.getNik().isEmpty()||!itempembimbing.getNik().equals("")){
                                pembimbing2 = itempembimbing.getName();
                            }
                        }
                        tv_pembimbing.setText(usn+" "+pembimbing2);
                    }
                    else {
                        tv_pembimbing.setText(usn);
                    }
                }
                else {
                    Toast.makeText(DetailTaMhsActivity.this,"server error dengan kode gak 200",Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<DetailTAMahasiswa> call, Throwable t) {
                Toast.makeText(DetailTaMhsActivity.this,"kamu lagi offline jadi gagal panggil server",Toast.LENGTH_SHORT);
            }
        });

        ImageButton ta2profil = (ImageButton) findViewById(R.id.detailta_btn_back);
        ta2profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profil = new Intent(DetailTaMhsActivity.this, DetailMahasiswaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("idtesis", idtesis);
                profil.putExtras(bundle);
                startActivity( profil);
            };
        });
    }
}