package com.mhdarslan.notificationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextMessage;
    private Button buttonChannel1, buttonChannel2;

    private NotificationHelper mNotificationHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.editText_title);
        editTextMessage = findViewById(R.id.editText_message);
        buttonChannel1 = findViewById(R.id.button_chan1);
        buttonChannel2 = findViewById(R.id.button_chan2);

        mNotificationHelper = new NotificationHelper(this);

        buttonChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel1(editTextTitle.getText().toString(), editTextMessage.getText().toString());
            }
        });

        buttonChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel2(editTextTitle.getText().toString(), editTextMessage.getText().toString());
            }
        });
    }

    private void sendOnChannel1(String title, String message) {
        NotificationCompat.Builder nb = mNotificationHelper.getChannel1Notification(title,message);
        mNotificationHelper.getManger().notify(1, nb.build());;
    }

    private void sendOnChannel2(String title, String message) {
        NotificationCompat.Builder nb = mNotificationHelper.getChannel2Notification(title,message);
        mNotificationHelper.getManger().notify(2, nb.build());;
    }
}
