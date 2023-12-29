package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class checkOut extends AppCompatActivity {
    Button reciept, pay;
    Fragment fg;
    ArrayList<Integer> hard, soft,drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        Bundle bundle = getIntent().getExtras();
        hard = bundle.getIntegerArrayList("hardfood");
        soft = bundle.getIntegerArrayList("softfood");
        drinks = bundle.getIntegerArrayList("drinks");


        reciept = findViewById(R.id.recieptBtn);
        pay = findViewById(R.id.payBtn);
        Bundle data = new Bundle();
        data.putIntegerArrayList("hardfood",hard);
        data.putIntegerArrayList("softfood",soft);
        data.putIntegerArrayList("drinks",drinks);

        reciept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fg = new FragmentReciept();
                FragmentManager fm = getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction ft = fm.beginTransaction();
                fg.setArguments(data);
                ft.replace(R.id.frameLayout, fg);
                ft.commit();
            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fg = new FragmentPay();
                FragmentManager fm = getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout, fg);
                ft.commit();
            }
        });
    }



}