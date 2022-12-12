package com.example.ismobile;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;


import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.ismobile.activity.DetailMahasiswaActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String CHANNEL_ID = "test_channel" ;
    private static final String TAG = "Service-Debug";
    private NotificationManagerCompat notificationManager;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        displayNotification(remoteMessage.getNotification()); // Notifikasi ada intent

    }


    // A. TIPE NOTIFIKASI 1 (ada intent)
    private void displayNotification(RemoteMessage.Notification notification) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Channel logbook", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("There's new Logbook!");
            NotificationManagerCompat.from(this).createNotificationChannel(channel);
        }

        Intent resultIntent = new Intent(this, DetailMahasiswaActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        //3. bikin builder notifikasi
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_round_notification_add_24)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setContentIntent(resultPendingIntent)
                .addAction(R.drawable.ic_round_notification_add_24, "PERGI", resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //4. bikin objek dan tampilkan notif
        NotificationManagerCompat.from(this).notify(2012, builder.build());
    }
}
