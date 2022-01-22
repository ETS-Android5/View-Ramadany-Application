package com.example.viewramadany;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AlFetewa extends AppCompatActivity {
    TextView name;TextView type;TextView channel;TextView channelValue;TextView display;TextView dispValue;TextView Redisplay;TextView RedispValue1;
    TextView stars;TextView starValue;TextView brief;TextView briefvalue;TextView promo;TextView promoValue;
    InputStream inputStream;

    String[] ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_fetewa);

        ImageView imageView4=(ImageView) findViewById(R.id.imageView4);
        imageView4.setImageResource(R.drawable.yasser);

        TextView name=(TextView) findViewById(R.id.textView7);TextView channelValue=(TextView) findViewById(R.id.textView9);TextView type=(TextView) findViewById(R.id.textView22);
        TextView dispValue=(TextView) findViewById(R.id.textView20);TextView RedispValue1=(TextView) findViewById(R.id.textView19);
        TextView starValue=(TextView) findViewById(R.id.textView13);TextView briefvalue=(TextView) findViewById(R.id.textView15);TextView promoValue=(TextView) findViewById(R.id.textView17);

        TextView[] temp={name,channelValue,type,starValue,briefvalue,dispValue,RedispValue1,promoValue};
        inputStream = getResources().openRawResource(R.raw.sample);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            csvLine = reader.readLine();
                csvLine = reader.readLine();
                ids=csvLine.split(",");

                for(int i=0;i<ids.length;i++){
                    temp[i].setText(ids[i]);
                }



        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file yasta: "+ex);
        }



    }
}