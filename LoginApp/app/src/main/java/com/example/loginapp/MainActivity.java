package com.example.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private ImageView ivTogglePassword;
    private RadioGroup rgLoginType;
    private CheckBox cbRememberMe;
    private TextView btnLogin, tvForgotPassword, tvSignUp;

    private boolean isPasswordVisible = false;

    private static final String PREFS_NAME = "login_prefs";
    private static final String KEY_REMEMBER = "remember_me";
    private static final String KEY_USERNAME = "saved_username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        ivTogglePassword = findViewById(R.id.ivTogglePassword);
        rgLoginType = findViewById(R.id.rgLoginType);
        cbRememberMe = findViewById(R.id.cbRememberMe);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvSignUp = findViewById(R.id.tvSignUp);

        loadRememberedUser();

        ivTogglePassword.setOnClickListener(v -> togglePasswordVisibility());

        rgLoginType.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbPhone) {
                etUsername.setHint("Enter your phone number");
                etUsername.setInputType(InputType.TYPE_CLASS_PHONE);
            } else {
                etUsername.setHint("Enter your email or username");
                etUsername.setInputType(InputType.TYPE_CLASS_TEXT);
            }
        });

        btnLogin.setOnClickListener(v -> attemptLogin());

        tvForgotPassword.setOnClickListener(v ->
                Toast.makeText(this, "Password reset link would be sent here", Toast.LENGTH_SHORT).show());

        tvSignUp.setOnClickListener(v ->
                Toast.makeText(this, "Navigate to Sign Up screen", Toast.LENGTH_SHORT).show());
    }

    private void togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible;
        int cursor = etPassword.getSelectionStart();
        if (isPasswordVisible) {
            etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            ivTogglePassword.setImageResource(R.drawable.ic_eye);
        } else {
            etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            ivTogglePassword.setImageResource(R.drawable.ic_eye_off);
        }
        if (cursor >= 0) {
            etPassword.setSelection(cursor);
        }
    }

    private void attemptLogin() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        boolean isPhoneMode = rgLoginType.getCheckedRadioButtonId() == R.id.rbPhone;

        if (TextUtils.isEmpty(username)) {
            etUsername.setError(isPhoneMode ? "Phone number is required" : "Email / username is required");
            etUsername.requestFocus();
            return;
        }

        if (!isPhoneMode && username.contains("@") && !Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            etUsername.setError("Enter a valid email address");
            etUsername.requestFocus();
            return;
        }

        if (isPhoneMode && username.length() < 7) {
            etUsername.setError("Enter a valid phone number");
            etUsername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters");
            etPassword.requestFocus();
            return;
        }

        saveRememberedUser(username);

        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
        finish();
    }

    private void saveRememberedUser(String username) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        if (cbRememberMe.isChecked()) {
            editor.putBoolean(KEY_REMEMBER, true);
            editor.putString(KEY_USERNAME, username);
        } else {
            editor.putBoolean(KEY_REMEMBER, false);
            editor.remove(KEY_USERNAME);
        }
        editor.apply();
    }

    private void loadRememberedUser() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean remembered = prefs.getBoolean(KEY_REMEMBER, false);
        if (remembered) {
            String savedUser = prefs.getString(KEY_USERNAME, "");
            etUsername.setText(savedUser);
            cbRememberMe.setChecked(true);
        }
    }
}
