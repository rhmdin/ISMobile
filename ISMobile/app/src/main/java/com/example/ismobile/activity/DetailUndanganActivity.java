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
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ismobile.R;
import com.example.ismobile.fragment.*;
import com.example.ismobile.model.LoginUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;



public class DetailUndanganActivity extends AppCompatActivity {

    private TextView detail_kategori, detail_judul_kategori, detail_nama, detail_nim;
    private Button acc,cancel;
    private static String TAG = "DetailMahasiswaActivity-Debug";
    private static final String CHANNEL_ID = "notif_logbook";
    private String kategori;
    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_undangan);
        detail_kategori = findViewById(R.id.detailjadwal_kategori);
        detail_judul_kategori = findViewById(R.id.detailjadwal_judulkategori);
        acc = (Button) findViewById(R.id.detailjadwal_btn_acc);
        cancel = (Button) findViewById(R.id.detailjadwal_btn_reject);

        Intent undangandetail = getIntent();
        final String[] kategori = {undangandetail.getStringExtra("undangan_kategori")};
        detail_kategori.setText(kategori[0]);
        detail_judul_kategori.setText("Detail "+ kategori[0]);

        Intent feedbacksemhas = new Intent(DetailUndanganActivity.this, DetailUndanganSeminarActivity.class);
        Intent feedbacksidang = new Intent(DetailUndanganActivity.this, DetailUndanganSidangActivity.class);

        //1. ambil notif manager
        notificationManager = NotificationManagerCompat.from(this);
        createNotificationChannel();

        JadwalDosenFragment jadwaldosenFragment = new JadwalDosenFragment();

        //cancel undangan
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundleinv = new Bundle();
                bundleinv.putString("statusinv","inv");
                jadwaldosenFragment.setArguments(bundleinv);

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new JadwalDosenFragment()).commit();
            };
        });

        //acc undangan
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kategori[0] = detail_kategori.getText().toString();
                if(TextUtils.equals(kategori[0], "Seminar Hasil")){
                    startActivity(feedbacksemhas);
                }
                else if(TextUtils.equals(kategori[0], getString(R.string.kategori2))){
                    startActivity(feedbacksidang);
                }

                //Intent detailsidang = new Intent(DetailUndanganActivity.this, DetailUndanganSidangActivity.class);
                Toast.makeText(DetailUndanganActivity.this, "Buka Detail Sidang", Toast.LENGTH_SHORT).show();

                Intent resultIntent = new Intent(DetailUndanganActivity.this, DetailUndanganSidangActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(DetailUndanganActivity.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                //3. bikin builder notifikasi
                NotificationCompat.Builder builder = new NotificationCompat.Builder(DetailUndanganActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_round_notification_add_24)
                        .setContentTitle("Invitation Notification Manual")
                        .setContentText("There's new Invitation!")
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.ic_round_notification_add_24, "Check Invitation", resultPendingIntent)
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
                        Toast.makeText(DetailUndanganActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    //2. bikin channel notif / daftarkan channel
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Invitation Notification Manual";
            String description = "There's new Invitation!";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}