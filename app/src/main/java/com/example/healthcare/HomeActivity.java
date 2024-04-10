package com.example.healthcare;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Récupération des préférences partagées
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);

        // Récupération du nom d'utilisateur
        String username = sharedPreferences.getString("username", "").toString();

        // Affichage d'un message d'accueil
        Toast.makeText(getApplicationContext(), "Welcome " + username, Toast.LENGTH_SHORT).show();

        // Bouton de déconnexion
        //Button btnLogout = findViewById(R.id.btnLogout);

        // Définir l'écouteur du clic sur le bouton
        //btnLogout.setOnClickListener(new View.OnClickListener() {
        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Effacer les préférences partagées
                SharedPreferences.Editor editor = sharedPreferences.edit();
                 editor.clear();
                editor.apply();

                // Démarrage de l'activité de connexion
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });
        CardView findDoctor =findViewById(R.id.cardFindDoctor);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, FindDoctorActivity.class));
            }
        });
        CardView labTest =findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, LabTestActivity.class));
            }
        });
    }
}
