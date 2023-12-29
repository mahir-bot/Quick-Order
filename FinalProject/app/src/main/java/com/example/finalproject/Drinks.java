package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class Drinks extends AppCompatActivity {
    RadioGroup pani, coke, juice, borhani, golap;
    ArrayList<Integer> hard, soft;
    ImageView h11, h12, h13, h14, h15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        pani = findViewById(R.id.Button_91);
        juice = findViewById(R.id.Button_93);
        coke = findViewById(R.id.Button_95);
        borhani = findViewById(R.id.Button_97);
        golap = findViewById(R.id.Button_89);

        h11 = findViewById(R.id.h11);
        h12 = findViewById(R.id.h12);
        h13 = findViewById(R.id.h13);
        h14 = findViewById(R.id.h14);
        h15 = findViewById(R.id.h15);



        Bundle bundle = getIntent().getExtras();
        hard = bundle.getIntegerArrayList("hardfood");
        soft = bundle.getIntegerArrayList("softfood");
    }

    public void BackSoft(View view) {
        Intent newIntent = new Intent(this, softFood.class);
        startActivity(newIntent);
    }

    public void Done(View view) {
        ArrayList<Integer> drinksNum = new ArrayList<>();
        if (pani.getCheckedRadioButtonId() == R.id.Button_92) {
            drinksNum.add(1);

        }
        if (juice.getCheckedRadioButtonId() == R.id.Button_94) {
            drinksNum.add(2);

        }
        if (coke.getCheckedRadioButtonId() == R.id.Button_96) {
            drinksNum.add(3);

        }
        if (borhani.getCheckedRadioButtonId() == R.id.Button_98) {
            drinksNum.add(4);

        }
        if (golap.getCheckedRadioButtonId() == R.id.Button_99) {
            drinksNum.add(5);
        }

        Intent check = new Intent(this, checkOut.class);
        check.putExtra("hardfood",hard);
        check.putExtra("softfood",soft);
        if (drinksNum.isEmpty())
            drinksNum.add(-1);
        check.putExtra("drinks",drinksNum);
        startActivity(check);

    }
}