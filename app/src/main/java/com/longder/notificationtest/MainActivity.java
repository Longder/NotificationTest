package com.longder.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button sendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.send_notice:
                        //通知管理器
                        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        //通知Builder
                        Notification.Builder builder = new Notification.Builder(MainActivity.this)
                                .setContentTitle("我是标题").setContentText("我是内容")
                                .setSmallIcon(R.drawable.ic_launcher).setWhen(System.currentTimeMillis());
                        //通过Builder创建通知
                        Notification notification = builder.build();
                        //构建intent
                        Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
                        //构建PendingIntent
                        //发送通知
                        manager.notify(1, notification);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
