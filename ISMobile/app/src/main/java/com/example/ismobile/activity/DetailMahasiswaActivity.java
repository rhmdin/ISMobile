package com.example.ismobile.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismobile.R;
import com.example.ismobile.api.APIClient;
import com.example.ismobile.modelapi.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMahasiswaActivity extends AppCompatActivity {

    private static String TAG = "DetailMahasiswaActivity-Debug";
    private static final String CHANNEL_ID = "notif_logbook";
    private NotificationManagerCompat notificationManager;
    private ImageButton logbook, nilai, cancel;
    private TextView tv_nim, tv_nama, tv_kontak, tv_tgl, tv_tmp, tv_waktu, tv_online, tv_penguji1, tv_penguji2, tv_penguji3;
    private String nama, token, gettoken, tgl, waktu, sejak;
    private int idtesis;
    private SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        //1. ambil notif manager
        notificationManager = NotificationManagerCompat.from(this);
        createNotificationChannel();

        tv_nama = findViewById(R.id.detailmhs_nama);
        tv_nim = findViewById(R.id.detailmhs_nim);
        tv_kontak = findViewById(R.id.detailmhs_kontak);
        tv_tgl = findViewById(R.id.detailmhs_tv_tgl);
        tv_tmp = findViewById(R.id.detailmhs_tv_tmp);
        tv_waktu = findViewById(R.id.detailmhs_tv_jam);
        tv_online = findViewById(R.id.detailmhs_tv_online);
        tv_penguji1 = findViewById(R.id.detailmhs_tv_penguji1);

        Bundle bundle = getIntent().getExtras();
        int idtesis = bundle.getInt("idtesis");
        final String[] mhsNama = new String[1];
        String mhsNim;
        /*tv_nama.setText(mhsNama);
        tv_nim.setText(mhsNim);*/

        sharedPreferences = getSharedPreferences("userkey", Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;

        Call<DetailTAMahasiswa> calldetailta = APIClient.getUserService().detailTAMhs(token, idtesis);
        calldetailta.enqueue(new Callback<DetailTAMahasiswa>() {
            @Override
            public void onResponse(Call<DetailTAMahasiswa> call, Response<DetailTAMahasiswa> response) {
                DetailTAMahasiswa detailTAMahasiswa = response.body();
                if(response.code()==200){

                    mhsNama[0] = detailTAMahasiswa.getStudent().getName();
                    tv_nama.setText(detailTAMahasiswa.getStudent().getName());
                    tv_nim.setText(detailTAMahasiswa.getStudent().getNim());
                    if(detailTAMahasiswa.getStudent().getPhone().isEmpty()||!detailTAMahasiswa.getStudent().getPhone().equals("")){
                        tv_kontak.setText("No Telepon. "+detailTAMahasiswa.getStudent().getPhone());
                    }
                    List<Seminars> listSeminar = detailTAMahasiswa.getSeminars();
                    for(Seminars itemseminar: listSeminar){
                        if(!itemseminar.getSeminarAt().isEmpty()||!itemseminar.getSeminarAt().equals("")){
                            tgl = Instant.parse(itemseminar.getSeminarAt())                // Parse this String in standard ISO 8601 format as a `Instant`, a point on the timeline in UTC. The `Z` means UTC.
                                    .atOffset( ZoneOffset.UTC )                                // Change from `Instant` to the more flexible `OffsetDateTime`.
                                    .format(                                                   // Generate a String representing the value of this `OffsetDateTime` object.
                                            DateTimeFormatter.ofPattern( "dd/MM/uuuu" )   // Specify a formatting pattern as desired.
                                    );
                            waktu = Instant.parse(itemseminar.getSeminarAt())                // Parse this String in standard ISO 8601 format as a `Instant`, a point on the timeline in UTC. The `Z` means UTC.
                                    .atOffset( ZoneOffset.UTC )                                // Change from `Instant` to the more flexible `OffsetDateTime`.
                                    .format(                                                   // Generate a String representing the value of this `OffsetDateTime` object.
                                            DateTimeFormatter.ofPattern( "HH:mm" )   // Specify a formatting pattern as desired.
                                    );
                            tv_tgl.setText("Tanggal : "+tgl);
                            tv_waktu.setText("Pukul     : "+waktu+" s.d. Selesai");
                            tv_tmp.setText("Tempat : Ruang "+itemseminar.getRoomId());
                            if(itemseminar.getOnlineUrl()==null){
                                tv_online.setText("Online  : -");
                            }
                            else {
                                tv_online.setText("Online: "+itemseminar.getOnlineUrl());
                            }
                        }
                    }
                 }
                else{
                    Toast.makeText(DetailMahasiswaActivity.this,"kode: "+response.code(),Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<DetailTAMahasiswa> call, Throwable t) {
                Toast.makeText(DetailMahasiswaActivity.this,"kamu lagi offline jadi gagal panggil server",Toast.LENGTH_SHORT);
            }
        });

        Call<DetailMahasiswa> calldetailmhs = APIClient.getUserService().detailMhs(token, idtesis);
        calldetailmhs.enqueue(new Callback<DetailMahasiswa>() {
            @Override
            public void onResponse(Call<DetailMahasiswa> call, Response<DetailMahasiswa> response) {
                DetailMahasiswa detailMahasiswa = response.body();
                if(response.code()==200){
                    List<Examiners> listPenguji = detailMahasiswa.getExaminers();
                    if (!listPenguji.isEmpty()||!listPenguji.contains(null)){
                        for(Examiners itempenguji: listPenguji){
                            if(!itempenguji.getNik().isEmpty()||!itempenguji.getNik().equals("")){
                                tv_penguji1.setText(itempenguji.getName());
                            }
                            else {
                                tv_penguji1.setText("Belum ada");
                            }
                        }
                    }
                    else {
                        tv_penguji1.setText("Belum ada");
                    }


                }
                else {
                    Toast.makeText(DetailMahasiswaActivity.this,"kode: "+response.code(),Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<DetailMahasiswa> call, Throwable t) {
                Toast.makeText(DetailMahasiswaActivity.this,"kamu lagi offline jadi gagal panggil server",Toast.LENGTH_SHORT);
            }
        });


        Log.d("usn", "login: " +nama);


        ImageButton profil2bimbingan = (ImageButton) findViewById(R.id.detailmhs_ib_back);
        profil2bimbingan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bimbingan = new Intent(DetailMahasiswaActivity.this, BimbinganActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("idtesis", idtesis);
                bimbingan.putExtras(bundle);
                startActivity( bimbingan);
            };
        });

        ImageButton btn_ta = (ImageButton) findViewById(R.id.ib_mhsbim_icon_ta);
        btn_ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent detailta = new Intent(DetailMahasiswaActivity.this, DetailTaMhsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("idtesis", idtesis);
                detailta.putExtras(bundle);
                Toast.makeText(DetailMahasiswaActivity.this,"Buka detail id "+mhsNama[0],Toast.LENGTH_SHORT);
                startActivity( detailta);
            };
        });
        ImageButton btn_logbook = (ImageButton) findViewById(R.id.ib_mhsbim_icon_logbook);
        btn_logbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhslogbook = new Intent(DetailMahasiswaActivity.this, LogbookActivity.class);
                Toast.makeText(DetailMahasiswaActivity.this, "Buka Logbook ", Toast.LENGTH_SHORT).show();

                startActivity(mhslogbook);

                Intent resultIntent = new Intent(DetailMahasiswaActivity.this, LogbookDetailActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(DetailMahasiswaActivity.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                //3. bikin builder notifikasi
                NotificationCompat.Builder builder = new NotificationCompat.Builder(DetailMahasiswaActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_round_notification_add_24)
                        .setContentTitle("Logbook Notification")
                        .setContentText("New Logbook from student")
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.ic_round_notification_add_24, "Check Logbook", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                //4. bikin objek dan tampilkan notif
                notificationManager.notify(2012, builder.build());
            };
        });

        // Kode token Firebase
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            System.out.println("Fetching FCM registration token failed");
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        System.out.println(token);
                    }
                });
    }

    //2. bikin channel notif / daftarkan channel
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Logbook Notification Manual";
            String description = "There's new Logbook!";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


}