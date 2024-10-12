package com.devmobile.tp4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SmsSendActivity extends AppCompatActivity {
    private Button sendSmsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_send);

        sendSmsButton = findViewById(R.id.sendSmsButton);

        String phoneNumber = getIntent().getStringExtra("PhoneNumber");

        sendSmsButton.setOnClickListener(v -> {
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
            smsIntent.setData(Uri.parse("smsto:" + phoneNumber));
            smsIntent.putExtra("sms_body", "Your SMS message here");

            startActivity(smsIntent);
        });
    }
}
