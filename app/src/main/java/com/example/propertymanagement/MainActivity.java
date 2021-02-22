package com.example.propertymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {
    EditText etPlot, etCust, etPrice, etCell;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        etPlot = findViewById(R.id.etPlot);
        etCust = findViewById(R.id.etCust);
        etPrice = findViewById(R.id.etPrice);
        etCell = findViewById(R.id.etCell);
    }

    public void insert(View v)
    {
        String Plot = etPlot.getText().toString().trim();
        String Cust = etCust.getText().toString().trim();
        String Price = etPrice.getText().toString().trim();
        String Cell = etCell.getText().toString().trim();

        if (Plot.isEmpty())
            etPlot.setError("Plot cant be empty");

       else if (Cust.isEmpty())
            etCust.setError("Cust cant be empty");

        else if (Price.isEmpty())
            etPrice.setError("Price cant be empty");

        else if (Cell.isEmpty())
            etCell.setError("Cell number cant be empty");

        else {
            HashMap<String, String> data= new HashMap<>();
            data.put("Plot", Plot);
            data.put("Cust", Cust);
            data.put("Price", Price);
            data.put("Cell", Cell);

            FirebaseDatabase.getInstance().getReference()
                    .child("Properties")
                    .push() //for unique key
                    .setValue(data)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(MainActivity.this, Plot+"has been inserted successfully", Toast.LENGTH_SHORT).show();
                }
            });

        }

    }

    public void viewData(View v)
    {
        startActivity(new Intent(MainActivity.this, ViewProperty.class));

    }
}