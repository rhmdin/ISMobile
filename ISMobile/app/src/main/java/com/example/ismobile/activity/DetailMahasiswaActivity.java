package com.example.ismobile.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismobile.R;

public class DetailMahasiswaActivity extends AppCompatActivity {

    private static String TAG = "DetailMahasiswaActivity-Debug";
    private static final String CHANNEL_ID = "notif_logbook";
    private NotificationManagerCompat notificationManager;
    private ImageButton logbook, nilai, cancel;
    private TextView detailmhs_nama, tv_nama;
    private String nama;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        //1. ambil notif manager
        notificationManager = NotificationManagerCompat.from(this);
        createNotificationChannel();

        detailmhs_nama = findViewById(R.id.detailmhs_nama);
        Intent bimbingandetail = getIntent();
        String nama = bimbingandetail.getStringExtra("bimbingan_nama");
        detailmhs_nama.setText(nama);
        tv_nama = (TextView) findViewById(R.id.detailmhs_nama);
        nama = tv_nama.getText().toString();
        ImageButton btn_nilai = (ImageButton) findViewById(R.id.ib_mhsbim_icon_nilai);
        ImageButton btn_logbook = (ImageButton) findViewById(R.id.ib_mhsbim_icon_logbook);

        Log.d("usn", "login: " +nama);

        btn_nilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedbacksidang = new Intent(DetailMahasiswaActivity.this, InputNilaiActivity.class);
                startActivity(feedbacksidang);
            };
        });
        btn_logbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhslogbook = new Intent(DetailMahasiswaActivity.this, LogbookActivity.class);
                Toast.makeText(DetailMahasiswaActivity.this, "Buka Logbook ", Toast.LENGTH_SHORT).show();

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
                        //.setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.ic_round_notification_add_24, "Check Logbook", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                //4. bikin objek dan tampilkan notif
                notificationManager.notify(2012, builder.build());
                startActivity(mhslogbook);

            };
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