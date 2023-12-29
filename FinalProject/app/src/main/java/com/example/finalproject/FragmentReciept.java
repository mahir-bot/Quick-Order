package com.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class FragmentReciept extends Fragment {

   View view;
   ListView lv;
TextView tv;
 ArrayList<Integer> hard,soft,drinks;
 ArrayList<String> ans;
 Integer total = 0,cnt = 1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_reciept,container,false);

        lv = view.findViewById(R.id.lvview);
        tv = view.findViewById(R.id.CostBtn);

        Bundle data = getArguments();


        assert data != null;
        hard = data.getIntegerArrayList("hardfood");
        soft = data.getIntegerArrayList("softfood");
        drinks = data.getIntegerArrayList("drinks");

        ArrayList<String> ans = new ArrayList<>();
        if(hard.get(0)!=-1)
        {
           for (int i = 0;i<hard.size();i++)
           {

               if(hard.get(i)==1)
               {
                   ans.add(cnt+": বিরিয়ানি - ১০০৳");
                   total+=100;
                   cnt++;
               }
               if(hard.get(i)==2)
               {
                   ans.add(cnt+": পোলাও   - ১০০৳");
                   cnt++;
                   total+=100;
               }
               if(hard.get(i)==3)
               {
                   ans.add(cnt+": খিচুড়ি     - ১০০৳"); cnt++;
                   total+=100;
               }
               if(hard.get(i)==4)
               {
                   ans.add(cnt+": নুডলস    - ১৫০৳"); cnt++;
                   total+=150;
               }
               if(hard.get(i)==5)
               {
                   ans.add(cnt+": সুপ         - ৩০০৳"); cnt++;
                   total+=300;
               }
           }
        }


        if(soft.get(0)!=-1)
        {
            for (int i = 0;i<soft.size();i++)
            {
                if(soft.get(i)==1)
                {
                    ans.add(cnt+": বার্গার - ১০০৳"); cnt++;
                    total+=100;
                }
                if(soft.get(i)==2)
                {
                    ans.add(cnt+": পিজা  - ১০০৳"); cnt++;
                    total+=100;
                }
                if(soft.get(i)==3)
                {
                    ans.add(cnt+": চিকেন - ১০০৳"); cnt++;
                    total+=100;
                }
                if(soft.get(i)==4)
                {
                    ans.add(cnt+": শর্মা     - ১৫০৳"); cnt++;
                    total+=150;
                }
                if(soft.get(i)==5)
                {
                    ans.add(cnt+": কেক   - ৩০০৳"); cnt++;
                    total+=300;
                }
            }
        }


        if(drinks.get(0)!=-1)
        {
            for (int i = 0;i<drinks.size();i++)
            {
                if(drinks.get(i)==1)
                {
                    ans.add(cnt+": পানি - ১০০৳"); cnt++;
                    total+=100;
                }
                if(drinks.get(i)==2)
                {
                    ans.add(cnt+": জুস  - ১০০৳"); cnt++;
                    total+=100;
                }
                if(drinks.get(i)==3)
                {
                    ans.add(cnt+": কোক - ১০০৳"); cnt++;
                    total+=100;
                }
                if(drinks.get(i)==4)
                {
                    ans.add(cnt+": বোরহানি     - ১৫০৳"); cnt++;
                    total+=150;
                }
                if(drinks.get(i)==5)
                {
                    ans.add(cnt+": কক্টেল  - ৩০০৳"); cnt++;
                    total+=300;
                }
            }
        }


        //ans.add("Total :"+ total + "Taka Only :)");


        ArrayAdapter<String> items = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, ans);

        lv.setAdapter(items);
        tv.setText("Total : "+ total);
        return view;
    }
}