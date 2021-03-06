package com.alessap.p2hrbthelper;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

/**
 * Used just to provide a persistent notification now.
 */
public class ForegroundService extends Service {
    private static final int NOTIF_ID = 2;
    public static final String NOTIF_CHANNEL_ID = "P2HRBT_FGSvc_Channel_Id";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("ForegroundService", "onBind:");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d("ForegroundService", "onStartCommand: ");

        startForeground();

        return super.onStartCommand(intent, flags, startId);
    }

    private void startForeground() {
        Log.d("ForegroundService", "Start Foreground");
        Intent notificationIntent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        startForeground(NOTIF_ID, new NotificationCompat.Builder(this,
                NOTIF_CHANNEL_ID) // don't forget create a notification channel first
                .setOngoing(true)
//                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(getString(R.string.app_name))
                .setContentText("Service is monitoring your Pebble")
                .setContentIntent(pendingIntent)
                .build());
    }
}

