package com.example.dentaldetectionapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class Signup extends AppCompatActivity {


    EditText ed_username,ed_email,ed_password, ed_confirmpassword;
    Button btn_register;
    ProgressBar progressbar;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        ed_email = findViewById(R.id.ed_email);
        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        ed_confirmpassword = findViewById(R.id.ed_confirmpassword);
        progressbar = findViewById(R.id.progressBar);
        btn_register = (Button) findViewById(R.id.btn_register);


        firebaseAuth = FirebaseAuth.getInstance();




        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = ed_username.getText().toString().trim();
                String email = ed_email.getText().toString().trim();
                String password = ed_password.getText().toString().trim();
                String confirmpassword = ed_confirmpassword.getText().toString().trim();



                if (TextUtils.isEmpty(username)){
                    Toast.makeText(Signup.this, "Please enter username", Toast.LENGTH_SHORT).show();
                    return;

                }


                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Signup.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;

                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Signup.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;

                }


                if (TextUtils.isEmpty(confirmpassword)){
                    Toast.makeText(Signup.this, "Confirm password", Toast.LENGTH_SHORT).show();
                    return;

                }


                if (password.length()< 6){

                    Toast.makeText(Signup.this, "Weak Password", Toast.LENGTH_SHORT).show();
                }

                progressbar.setVisibility(View.VISIBLE);



                if (password.equals(confirmpassword)){


                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressbar.setVisibility(View.GONE);



                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(), Dashboard.class));
                                        Toast.makeText(Signup.this, "Sign up Successful", Toast.LENGTH_SHORT).show();



                                    }


                                    else {
                                        Toast.makeText(Signup.this, "Authentication Failed", Toast.LENGTH_SHORT).show();



                                    }

                                    // ...
                                }
                            });


                }

            }
        });





    }


    public void moveToLogin(View view) {

        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

    public void Register(View view) {

        if(ed_username.getText().toString().equals("")){
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
        }
        else if(ed_email.getText().toString().equals("")){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }
        else if(ed_password.getText().toString().equals("")){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Registration Click", Toast.LENGTH_SHORT).show();
        }

    }
}
