package com.example.dentaldetectionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    Button button_package, button_profile, button_remedies, button_medicine, button_doctor, button_camera;
    Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        button_profile = (Button) findViewById(R.id.button_profile);
        button_package = (Button) findViewById(R.id.button_package);
        button_remedies = (Button) findViewById(R.id.button_remedies);
        button_medicine = (Button) findViewById(R.id.button_medicine);
        button_doctor = (Button) findViewById(R.id.button_doctor);
        button_camera = (Button) findViewById(R.id.button_camera);






        button_remedies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Remedies Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        button_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Medicines Clicked", Toast.LENGTH_SHORT).show();
            }
        });



        button_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Doctor Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        button_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Camera.class));
                Toast.makeText(Dashboard.this, "Camera Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
                Toast.makeText(Dashboard.this, "Profile Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        button_package.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Package Clicked", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
