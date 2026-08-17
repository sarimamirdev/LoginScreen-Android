package com.example.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView tvWelcome = findViewById(R.id.tvWelcome);
        TextView btnLogout = findViewById(R.id.btnLogout);

        String username = getIntent().getStringExtra("username");
        if (username != null && !username.isEmpty()) {
            tvWelcome.setText("Welcome, " + username + "!");
        }

        btnLogout.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("login_prefs", MODE_PRIVATE);
            boolean remembered = prefs.getBoolean("remember_me", false);
            if (!remembered) {
                prefs.edit().remove("saved_username").apply();
            }
            startActivity(new Intent(HomeActivity.this, MainActivity.class));
            finish();
        });
    }
}
