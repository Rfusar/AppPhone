package com.autotech.MyApp.utils;
import com.autotech.MyApp.R;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class Notifica {
    private static Notifica instance;
    private AlarmManager am;
    private PendingIntent pi;
    private Context c;

    private Notifica(Context c){
        this.c = c.getApplicationContext();
        am = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(c, NotificationReceiver.class);
        pi = PendingIntent.getBroadcast(c, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public static Notifica getInstance(Context c){
        if(instance == null){ instance = new Notifica(c);}
        return instance;
    }

    public void startRepeatingAlarm(){
        long interval = 5*60*1000;
        long startTime = System.currentTimeMillis();
        if(am != null){
            am.setInexactRepeating(AlarmManager.RTC_WAKEUP, startTime, interval, pi);
        }
    }

    public void stopAlarm(){
        if (am!=null){am.cancel(pi);}
    }

    public static class NotificationReceiver extends BroadcastReceiver{ 
        @Override
        public void onReceive(Context c, Intent i){ createNotification(c);}

        private void createNotification(Context c){
            String channelId = "my_channel_id";
            NotificationManager nm = (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);
            if(nm==null){return;}

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                NotificationChannel channel = new NotificationChannel(channelId, "My Channel", NotificationManager.IMPORTANCE_DEFAULT);
                nm.createNotificationChannel(channel);

            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(c, channelId)
                .setSmallIcon(R.drawable.icon_app)
                .setContentTitle("Torna all'app, ORA")
                .setContentText("Hey è da un po che non ti fai vedere...")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

            nm.notify(1, builder.build());
        }
    }
}
