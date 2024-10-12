package com.devmobile.tp4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfilActivity extends AppCompatActivity {
    private Button emailButton, callButton, smsButton, backButton;
    private EditText phoneNumberEditText;
    private ImageView profileImageView;
    private TextView userNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        emailButton = findViewById(R.id.emailButton);
        callButton = findViewById(R.id.callButton);
        smsButton = findViewById(R.id.smsButton);
        backButton = findViewById(R.id.backButton);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        profileImageView = findViewById(R.id.profileImageView);
        userNameTextView = findViewById(R.id.userNameTextView);

        String username = getIntent().getStringExtra("username");
        userNameTextView.setText(username != null ? username : "Guest");

        emailButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfilActivity.this, EmailSendActivity.class);
            startActivity(intent);
        });

        callButton.setOnClickListener(v -> {
            String phoneNumber = phoneNumberEditText.getText().toString();
            if (!phoneNumber.isEmpty()) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(callIntent);
            } else {
                Toast.makeText(ProfilActivity.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
            }
        });

        smsButton.setOnClickListener(v -> {
            String phoneNumber = phoneNumberEditText.getText().toString();
            if (!phoneNumber.isEmpty()) {
                Intent smsIntent = new Intent(ProfilActivity.this, SmsSendActivity.class);
                smsIntent.putExtra("PhoneNumber", phoneNumber);
                startActivity(smsIntent);
            } else {
                Toast.makeText(ProfilActivity.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfilActivity.this, SuiteActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ProfilActivity.this, SuiteActivity.class);
        startActivity(intent);
    }
}