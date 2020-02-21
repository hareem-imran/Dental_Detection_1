package com.example.dentaldetectionapp;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText ed_email,ed_password;
    Button btn_login;
    private FirebaseAuth firebaseAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_email = findViewById(R.id.ed_email);
        ed_password = findViewById(R.id.ed_password);
        btn_login = findViewById(R.id.btn_login);
        firebaseAuth = FirebaseAuth.getInstance();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ed_email.getText().toString().trim();
                String password = ed_password.getText().toString().trim();




                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Login.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;

                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Login.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;

                }



                if (password.length()< 6){

                    Toast.makeText(Login.this, "Weak Password", Toast.LENGTH_SHORT).show();
                }



                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(), Dashboard.class));
                                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();


                                } else {

                                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });


            }
        });





    }



    public void Login(View view) {

        if(ed_email.getText().toString().equals("")){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }
        else if(ed_password.getText().toString().equals("")){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Login Click", Toast.LENGTH_SHORT).show();
        }
    }

    public void moveToRegistration(View view) {
        startActivity(new Intent(getApplicationContext(),Signup.class));
        finish();
    }
}
