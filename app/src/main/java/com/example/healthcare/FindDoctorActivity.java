package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        CardView exit =findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity( new Intent(FindDoctorActivity.this,HomeActivity.class));
            }
        });
        CardView familyphysician=findViewById(R.id.cardFDFamilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","family Physicians");
                startActivity(it);
            }
        });
        CardView dietician=findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });
        CardView dentist=findViewById(R.id.cardFDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","dentist");
                startActivity(it);
            }
        });
        CardView surgeon=findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","surgeon");
                startActivity(it);
            }
        });
        CardView cardiologists =findViewById(R.id.cardFDCardiologists);
        cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","cardiologists");
                startActivity(it);
            }
        });

    }
}
