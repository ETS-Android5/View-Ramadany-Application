package com.example.viewramadany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ListView list1=findViewById(R.id.thelist);


        ArrayList<String> Data1=new ArrayList<>();
        Data1.add("El-Hekaya");
        Data1.add("Al-Abakera");

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,Data1);
        list1.setAdapter(adapter);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent7=new Intent(view.getContext(),ElHekaya.class);
                    startActivityForResult(intent7,0);
                }

                if (position==1){
                    Intent intent7=new Intent(view.getContext(),Alabakera.class);
                    startActivityForResult(intent7,1);
                }


            }
        });
    }
}
