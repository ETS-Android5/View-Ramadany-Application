package com.example.viewramadany;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

     TextView email1;
     EditText Lemail;
     TextView pass1;
     EditText Lpass;
     Button confirm;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    int i=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mFirebaseAuth = FirebaseAuth.getInstance();

        ImageView imageView2=(ImageView) findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.su);

        email1=(TextView) findViewById(R.id.textView);
        Lemail=(EditText) findViewById(R.id.editText2);

         pass1=(TextView) findViewById(R.id.textView2);
        Lpass=(EditText) findViewById(R.id.editText3);
        confirm=(Button) findViewById(R.id.button3);

        mAuthStateListener  = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if( mFirebaseUser != null ){
                    Toast.makeText(Main2Activity.this,"You are logged in",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Main2Activity.this, Main4Activity.class));
                }
                else{
                    if(i==0)
                    Toast.makeText(Main2Activity.this,"Please Login ",Toast.LENGTH_SHORT).show();
                    else
                    Toast.makeText(Main2Activity.this,"Please Retry Login Again",Toast.LENGTH_SHORT).show();

                    i=i+1;
            }
            }
        };

        confirm.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String email = Lemail.getText().toString();
            String pwd = Lpass.getText().toString();
            if(email.isEmpty()){
                Lemail.setError("Please enter email id");
                Lemail.requestFocus();
            }
            else  if(pwd.isEmpty()){
                Lpass.setError("Please enter your password");
                Lpass.requestFocus();
            }
            else  if(email.isEmpty() && pwd.isEmpty()){
                Toast.makeText(Main2Activity.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
            }
            else  if(!(email.isEmpty() && pwd.isEmpty())){
                mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            //byt2kd en el pass mtwafeq m3 el mail
                            Toast.makeText(Main2Activity.this,"Log In Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            startActivity(new Intent(Main2Activity.this, Main4Activity.class));
                        }
                    }
                });
            }
            else{
                Toast.makeText(Main2Activity.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

            }
        }
    });

    }
    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
