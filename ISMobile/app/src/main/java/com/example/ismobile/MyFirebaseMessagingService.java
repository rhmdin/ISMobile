package com.example.ismobile;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.ismobile.activity.LogbookDetailActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public MyFirebaseMessagingService() {
    }
    private static final String CHANNEL_ID = "test_channel" ;
    private static final String TAG = "Service-Debug";
    private NotificationManagerCompat notificationManager;

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "Refreshed token: " + token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
            displayNotification2(remoteMessage.getNotification()); // Notifikasi tidak ada intent
    }

    // A. TIPE NOTIFIKASI 1 (ada intent)
    private void displayNotification(RemoteMessage.Notification notification) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Channel Contoh", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Ini hanya channel untuk contoh notifikasi");
            NotificationManagerCompat.from(this).createNotificationChannel(channel);
        }

        //3. builder utk buat notif
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_round_notification_add_24)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //5.Tampilkan notifikasi
        NotificationManagerCompat.from(this).notify(101, builder.build());
    }

    // B. TIPE NOTIFIKASI 2 (tidak ada intent)
    private void displayNotification2(RemoteMessage.Notification notification) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Logbook Notification FCM", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("There's new Logbook from student!");
            NotificationManagerCompat.from(this).createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_round_notification_add_24)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Tampilkan notifikasi
        NotificationManagerCompat.from(this).notify(101, builder.build());
    }
}