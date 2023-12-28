package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityHomePageeBinding;

public class HomePagee extends AppCompatActivity {
    EditText Emaill,Pass;
    Button Login1,SignUp1;
    private AppBarConfiguration appBarConfiguration;
    private ActivityHomePageeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomePageeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_home_pagee);
        Emaill = (EditText) findViewById(R.id.edEmail);
        Pass = (EditText) findViewById(R.id.Passwordd);
        Login1 = (Button) findViewById(R.id.login);
        SignUp1 = (Button) findViewById(R.id.signup);

        Login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaile = Emaill.getText().toString();
                String passworde = Pass.getText().toString();

                Intent intent = new Intent(HomePagee.this, MainActivity.class);
                startActivity(intent);

                if (TextUtils.isEmpty(emaile) && TextUtils.isEmpty(passworde)) {
                    Toast.makeText(getApplicationContext(), "Please enter both !", Toast.LENGTH_LONG).show();

                }


            }

        });

        SignUp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(HomePagee.this, SignUpPagee.class);
                startActivity(intent);
            }
        });

    }
}