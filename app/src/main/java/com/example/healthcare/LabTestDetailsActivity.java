package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailsActivity extends AppCompatActivity {
    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    Button btnAddToCart, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName = findViewById(R.id.textViewLDPackageName);
        tvTotalCost = findViewById(R.id.textViewTotalCost);
        edDetails = findViewById(R.id.editTextLDTextMultine);
        btnBack=findViewById(R.id.buttonLDBack);
        btnAddToCart=findViewById(R.id.buttonLDAddToCart);

        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        if (intent != null) {
            String packageName = intent.getStringExtra("text1");
            String details = intent.getStringExtra("text2");
            String totalCost = intent.getStringExtra("text3");

            if (packageName != null) {
                tvPackageName.setText(packageName);
            }
            if (details != null) {
                edDetails.setText(details);
            }
            if (totalCost != null) {
                tvTotalCost.setText("Total Cost: " + totalCost);
            }
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username", "");

                // Obtenir les détails du produit de l'intent
                Intent intent = getIntent();
                String product = intent.getStringExtra("text1");
                float price = intent.getFloatExtra("text3", 0.0f); // Utilisation d'une valeur par défaut de 0.0 si le prix n'est pas trouvé

                // Vérifier si les valeurs sont valides
                if (username.isEmpty() || product == null) {
                    Toast.makeText(LabTestDetailsActivity.this, "Unable to add product to cart", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Ajouter le produit au panier
                Database db = new Database(LabTestDetailsActivity.this, "healthcare", null, 1);
                if (db.checkCart(username, product) == 1) {
                    Toast.makeText(LabTestDetailsActivity.this, "Product Already Added", Toast.LENGTH_SHORT).show();
                } else {
                    db.addToCart(username, product, price, "Lab");
                    Toast.makeText(LabTestDetailsActivity.this, "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                }

                // Rediriger vers l'activité LabTestActivity après l'ajout au panier
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });

        /*btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(LabTestDetailsActivity.this, CartLabActivity.class));
            }
        });*/


    }
}
