package com.hackmate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    
    private FirebaseAuth mAuth;
    private TextView tvWelcome;
    private Button btnLogout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mAuth = FirebaseAuth.getInstance();
        
        initViews();
        setupUserInfo();
        setupClickListeners();
    }
    
    private void initViews() {
        tvWelcome = findViewById(R.id.tvWelcome);
        btnLogout = findViewById(R.id.btnLogout);
    }
    
    private void setupUserInfo() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String displayName = currentUser.getDisplayName();
            String email = currentUser.getEmail();
            String welcomeText = "Welcome to HackMate!\n\n" + 
                               "Name: " + (displayName != null ? displayName : "Not provided") + "\n" +
                               "Email: " + (email != null ? email : "Not provided");
            tvWelcome.setText(welcomeText);
        } else {
            // User not logged in, redirect to login
            redirectToLogin();
        }
    }
    
    private void setupClickListeners() {
        btnLogout.setOnClickListener(v -> {
            mAuth.signOut();
            redirectToLogin();
        });
    }
    
    private void redirectToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
