package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class register extends AppCompatActivity {
    EditText phone, password, fullname, email, passAgain;
    Button regbtn;
    TextView logon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        phone = findViewById(R.id.userPhone);
        password = findViewById(R.id.userPassword);
        fullname = findViewById(R.id.userName);
        email = findViewById(R.id.userEmail);
        passAgain = findViewById(R.id.userAgainPassword);
        regbtn = findViewById(R.id.userRegister);
        logon = findViewById(R.id.loginNow);
        logon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent check = new Intent(register.this, login.class);
                startActivity(check);

            }
        });
    }

    public void newAccount(View view) {

        final String phn = phone.getText().toString();
        final String pas = password.getText().toString();
        final String nam = fullname.getText().toString();
        final String mail = email.getText().toString();
        final String passAga = passAgain.getText().toString();

        if (phn.isEmpty() || pas.isEmpty() || nam.isEmpty() || mail.isEmpty() || passAga.isEmpty()) {
            Toast.makeText(this, "Empty field Found", Toast.LENGTH_SHORT).show();
        } else if (!pas.equals(passAga)) {

            Toast.makeText(this, "Password Didn't Matched!", Toast.LENGTH_SHORT).show();
        } else {


            FirebaseDatabase db=FirebaseDatabase.getInstance();
            DatabaseReference databaseReference=db.getReference("users").child("phn");


            databaseReference.child("phn").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(phn)) {
                        Toast.makeText(register.this, "Already Have an Account", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        databaseReference.child("users").child(phn).child("FullName").setValue(nam);
                        databaseReference.child("users").child(phn).child("Email").setValue(email);
                        databaseReference.child("users").child(phn).child("Password").setValue(pas);
                        Toast.makeText(register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                        Intent check = new Intent(register.this, HardFood.class);
                        startActivity(check);


                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }


    }
}