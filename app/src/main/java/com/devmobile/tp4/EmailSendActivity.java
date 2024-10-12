package com.devmobile.tp4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class EmailSendActivity extends AppCompatActivity {
    private Button sendEmailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_send);

        sendEmailButton = findViewById(R.id.sendEmailButton);

        String emailX = getIntent().getStringExtra("EmailUSERX");

        sendEmailButton.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailX});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your Subject Here");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message here");

            startActivity(Intent.createChooser(emailIntent, "Choose an Email client:"));
        });
    }
}
