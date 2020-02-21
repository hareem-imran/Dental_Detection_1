package com.example.dentaldetectionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile extends AppCompatActivity {
EditText sym, sym1;
Button btn_search;
DatabaseReference reff;
Patient patient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sym=(EditText)findViewById(R.id.sym);
        sym1=(EditText)findViewById(R.id.sym1);
        btn_search=(Button)findViewById(R.id.btn_search);
        patient=new Patient();
        reff= FirebaseDatabase.getInstance().getReference().child("Patient");
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patient.setSymptoms1(sym.getText().toString().trim());
                patient.setSymptoms2(sym1.getText().toString().trim());
                reff.push().setValue(patient);
                Toast.makeText(Profile.this, "Searching...", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
