package com.example.viewramadany;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main4Activity extends AppCompatActivity {
    Button Moslsalat;
    Button Program;
    Button btnLogout;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser user;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

         Moslsalat=(Button) findViewById(R.id.button5);
         Program=(Button) findViewById(R.id.button6);
        btnLogout=(Button) findViewById(R.id.button7);
        user = FirebaseAuth.getInstance().getCurrentUser();

        Moslsalat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5a=new Intent(Main4Activity.this, Main5Activity.class);
                startActivity(intent5a);
            }
        });
        Program.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5b=new Intent(Main4Activity.this, Main6Activity.class);
                startActivity(intent5b);
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Main4Activity.this,"You are Successfully Signed out"+'\n'+"            See You Later",Toast.LENGTH_LONG).show();

                Intent intToMain = new Intent(Main4Activity.this, MainActivity.class);
                intToMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); //byms7 el mem reference or overwrite on it
                startActivity(intToMain);
                //finish();
                //System.exit(0);


                user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                        }
                    }
                });
            }
        });




    }
}
