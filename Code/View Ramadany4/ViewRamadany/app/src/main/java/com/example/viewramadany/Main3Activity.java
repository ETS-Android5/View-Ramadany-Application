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

public class Main3Activity extends AppCompatActivity {

    TextView Name;
    EditText Sname;
    TextView email2;
    EditText Semail;
    TextView pass2;
    EditText Spass;
    TextView passAgain;
    EditText SpassAgain;
    Button done;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mFirebaseAuth = FirebaseAuth.getInstance();

        ImageView imageView3=(ImageView) findViewById(R.id.imageView3);
        imageView3.setImageResource(R.drawable.li);

         Name=(TextView) findViewById(R.id.textView3);
         Sname=(EditText) findViewById(R.id.editText);

         email2=(TextView) findViewById(R.id.textView4);
         Semail=(EditText) findViewById(R.id.editText4);

         pass2=(TextView) findViewById(R.id.textView5);
         Spass=(EditText) findViewById(R.id.editText5);
         passAgain=(TextView) findViewById(R.id.textView6);
         SpassAgain=(EditText) findViewById(R.id.editText6);

         done=(Button) findViewById(R.id.button4);
        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nm = Sname.getText().toString();
                String email = Semail.getText().toString();
                String pwd = Spass.getText().toString();
                String pwdr = SpassAgain.getText().toString();
                if(email.isEmpty()){
                    Semail.setError("Please enter email id");
                    Semail.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    Spass.setError("Please enter your password");
                    Spass.requestFocus();
                }
                else if(nm.isEmpty()){
                    Sname.setError("Please enter your password");
                    Sname.requestFocus();
                }
                else if(pwdr.isEmpty()){
                    SpassAgain.setError("Please enter your password");
                    SpassAgain.requestFocus();

                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(Main3Activity.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                }
                else  if(!(pwd.equals(pwdr))){
                    Toast.makeText(Main3Activity.this,"Passwords are not matched!",Toast.LENGTH_SHORT).show();
                }

                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(Main3Activity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Main3Activity.this,"Sign up Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(Main3Activity.this, Main4Activity.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Main3Activity.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
