package io.rasprovers.remotus.services;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;

import io.rasprovers.remotus.R;

/**
 * Created by betterclever on 4/14/2017.
 */

public class ExampleBackgroundService extends Service {
    
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    private BroadcastReceiver broadcastReceiver;
    private IntentFilter filter;
    
    
    public ExampleBackgroundService() {
       
        filter = new IntentFilter(Intent.ACTION_TIME_TICK);
        filter.matchAction(Intent.ACTION_TIME_CHANGED);
        filter.matchAction(Intent.ACTION_TIMEZONE_CHANGED);
        filter.matchAction(Intent.ACTION_DATE_CHANGED);
        
        broadcastReceiver = new BroadcastReceiver() {
            
            @Override
            public void onReceive(Context context, Intent intent) {
                int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                int minute = Calendar.getInstance().get(Calendar.MINUTE);
                
                    NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(ExampleBackgroundService.this)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("Hi Dude")
                            .setContentText("Time is " + hour + ": " + minute);
    
                    int mNotificationId = hour * 100 + minute;
                    NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    mNotifyMgr.notify(mNotificationId, builder.build());
                
            }
        };
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        registerReceiver(broadcastReceiver,filter);
    }
    
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }
}
