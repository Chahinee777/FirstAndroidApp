package com.devmobile.tp4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText identifierEditText;
    private EditText emailEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        identifierEditText = findViewById(R.id.identifierEditText);
        emailEditText = findViewById(R.id.emailEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = identifierEditText.getText().toString();
                String email = emailEditText.getText().toString();
                Intent intent = new Intent(LoginActivity.this, SuiteActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}