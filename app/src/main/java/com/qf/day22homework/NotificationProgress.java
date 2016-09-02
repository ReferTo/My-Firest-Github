package com.qf.day22homework;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Created by lenovo on 2016/8/23.
 */
public class NotificationProgress extends BroadcastReceiver{
    NotificationManager manager;
    Notification notification;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.qf.game")){
         int  progress=intent.getExtras().getInt("progress");
            manager= (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
            notification=new Notification(R.mipmap.ic_launcher,
                    "海贼王",System.currentTimeMillis());
            RemoteViews remoteViews=new RemoteViews(context.getPackageName(),
                    R.layout.my_notification);
            notification.contentView=remoteViews;
            notification.contentView.setProgressBar(R.id.progressId,100,progress,false);
            manager.notify(1,notification);
//            myProgress=(MyProgress) context;
//            Log.d("refer","======"+progress);
//            myProgress.onProgress(progress);
        }
    }
}
