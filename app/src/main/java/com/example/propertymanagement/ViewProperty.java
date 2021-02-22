package com.example.propertymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Property;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ViewProperty extends AppCompatActivity {

    RecyclerView recyclerView;
    PropertyAdapter propertyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<PropertyModel> options =
                new FirebaseRecyclerOptions.Builder<PropertyModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Property"), PropertyModel.class)
                        .build();

        propertyAdapter = new PropertyAdapter(options, this);
        recyclerView.setAdapter(propertyAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        propertyAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        propertyAdapter.stopListening();
    }
}