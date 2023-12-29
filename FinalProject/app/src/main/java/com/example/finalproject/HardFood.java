package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HardFood extends AppCompatActivity {
    RadioGroup biriyani, polao, soup, noodles, khichuri;

   ImageView  h1, h2, h3, h4, h5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_food);
        biriyani = findViewById(R.id.Button_1);
        polao = findViewById(R.id.Button_2);
        khichuri = findViewById(R.id.Button_3);
        soup = findViewById(R.id.Button_5);
        noodles = findViewById(R.id.Button_4);

        h1 = findViewById(R.id.h1);
        h2 = findViewById(R.id.h2);
        h3 = findViewById(R.id.h3);
        h4 = findViewById(R.id.h4);
        h5 = findViewById(R.id.h5);


    }

    public void BackMain(View view) {
        Intent newIntent = new Intent(this, MainActivity.class);
        startActivity(newIntent);
    }

    public void softFood(View view) {


        ArrayList<Integer> foodNum = new ArrayList<>();
        if (biriyani.getCheckedRadioButtonId() == R.id.Button_11) {
            foodNum.add(1);

        }
        if (polao.getCheckedRadioButtonId() == R.id.Button_22) {
            foodNum.add(2);

        }
        if (khichuri.getCheckedRadioButtonId() == R.id.Button_33) {
            foodNum.add(3);

        }
        if (noodles.getCheckedRadioButtonId() == R.id.Button_44) {
            foodNum.add(4);

        }
        if (soup.getCheckedRadioButtonId() == R.id.Button_55) {
            foodNum.add(5);
        }
        Intent soft = new Intent(this, softFood.class);
        if (foodNum.isEmpty())
            foodNum.add(-1);
        soft.putExtra("hardfood", foodNum);
        startActivity(soft);



    }
}