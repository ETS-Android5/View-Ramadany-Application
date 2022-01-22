package com.example.viewramadany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ListView list=findViewById(R.id.thelist);


        ArrayList<String> Data=new ArrayList<>();
        Data.add("Al-Fetewa");
        Data.add("Al-Prince");
        Data.add("El-Ekhtyar");

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,Data);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent6=new Intent(view.getContext(),AlFetewa.class);
                    startActivityForResult(intent6,0);
                }

                if (position==1){
                    Intent intent6=new Intent(view.getContext(),AlPrince.class);
                    startActivityForResult(intent6,1);
                }
                if (position==2){
                    Intent intent6=new Intent(view.getContext(),ElEkhtyar.class);
                    startActivityForResult(intent6,2);
                }


            }
        });
    }
}
