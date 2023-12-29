package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class softFood extends AppCompatActivity {
    RadioGroup burger, pizza, chiken, cake, shorma;
    ArrayList<Integer> hard;
    ImageView h6,h7,h8,h9,h10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_food);
        burger = findViewById(R.id.Button_10);
        pizza = findViewById(R.id.Button_20);
        chiken = findViewById(R.id.Button_30);
        shorma = findViewById(R.id.Button_40);
        cake = findViewById(R.id.Button_50);

        h6 = findViewById(R.id.h6);
        h7 = findViewById(R.id.h7);
        h8 = findViewById(R.id.h8);
        h9 = findViewById(R.id.h9);
        h10 = findViewById(R.id.h10);

        Bundle bundle = getIntent().getExtras();
        hard = bundle.getIntegerArrayList("hardfood");

    }

    public void BackHard(View view) {

        Intent newIntent = new Intent(this, HardFood.class);
        startActivity(newIntent);

    }

    public void Drinks(View view) {

        ArrayList<Integer> softNum = new ArrayList<>();
        if (burger.getCheckedRadioButtonId() == R.id.Button_12) {
            softNum.add(1);

        }
        if (pizza.getCheckedRadioButtonId() == R.id.Button_23) {
            softNum.add(2);

        }
        if (chiken.getCheckedRadioButtonId() == R.id.Button_34) {
            softNum.add(3);

        }
        if (shorma.getCheckedRadioButtonId() == R.id.Button_45) {
            softNum.add(4);

        }
        if (cake.getCheckedRadioButtonId() == R.id.Button_56) {
            softNum.add(5);
        }

        Intent Drinks = new Intent(this, Drinks.class);
        Drinks.putExtra("hardfood",hard);
        if (softNum.isEmpty())
            softNum.add(-1);
        Drinks.putExtra("softfood",softNum);
        startActivity(Drinks);
    }
}