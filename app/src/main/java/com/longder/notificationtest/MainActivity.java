package com.longder.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;

import android.app.PendingIntent;
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
                        //构建intent
                        Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
                        /**
                         * 通过intent构建PendingIntent（准备即将启动一个Activity的intent）
                         * PendingIntent是用来指定当用户点击通知后接下来要做的事。
                         * 他区别于Intent的点在于：不是立即发生。
                         */
                        PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
                        //将PendingIntent加入Builder中
                        builder.setContentIntent(pi);
                        //通过Builder创建通知
                        Notification notification = builder.build();
                        //发送通知（第一参数指定了一个id值和发送的通知绑定。主要是起到唯一标识的作用。）
                        manager.notify(1, notification);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
