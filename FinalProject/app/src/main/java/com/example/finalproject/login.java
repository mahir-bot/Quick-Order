package com.example.finalproject;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText phone, password;
    Button lgbtn;
    TextView registerbtnnow;
    String phoneTxt, passTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        lgbtn = findViewById(R.id.login);
        registerbtnnow = findViewById(R.id.regNow);
        registerbtnnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent check = new Intent(login.this, register.class);
                startActivity(check);
            }
        });
    }

    public void goHard(View view) {

        phoneTxt = phone.getText().toString();
        passTxt = password.getText().toString();

        if (phoneTxt.isEmpty() || passTxt.isEmpty()) {
            Toast.makeText(this, "Please Enter Your phone number or Password!", Toast.LENGTH_SHORT).show();
        } else {

        }

        Intent check = new Intent(this, HardFood.class);
        startActivity(check);


    }




}
