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

import com.example.myapplication.databinding.ActivitySignUpPageeBinding;

public class SignUpPagee extends AppCompatActivity {
    EditText Email2, Pass2;
    Button SingUpp ,ContactUss;
    private AppBarConfiguration appBarConfiguration;
    private ActivitySignUpPageeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpPageeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Email2 = (EditText) findViewById(R.id.signemail);
        Pass2 = (EditText) findViewById(R.id.signpass);
        SingUpp = (Button) findViewById(R.id.signn);

        SingUpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SignUpPagee.this, HomePagee.class);
                startActivity(intent);

                String NewEmaill = Email2.getText().toString();
                String NewPass = Pass2.getText().toString();

                String nam, Ln, Emm, Pn, age, pass;

                Emm = Email2.getText().toString();
                pass = Pass2.getText().toString();
                if (TextUtils.isEmpty(Emm)) {
                    Toast.makeText(getApplicationContext(), "Please enter Emaill!!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(getApplicationContext(), "Please enter password!!!", Toast.LENGTH_LONG).show();
                    return;
                }

            }
        });
        ContactUss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(SignUpPagee.this, ContactUs.class);
                startActivity(intent);

            }
        });

    }
}