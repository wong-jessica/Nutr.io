package com.example.cs125_nutrigainsofficial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class IngredientActivity extends AppCompatActivity {
    ArrayList<String> ingredientItemsList =new ArrayList<>();
    ArrayAdapter<String> adapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseUsers = database.getReference("users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient);
        FirebaseApp.initializeApp(this);
    }

    @Override
     protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("ID");

        final EditText newIngredienteditText = findViewById(R.id.newIngredienteditText);
        ListView IngredientListView = findViewById(R.id.IngredietListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ingredientItemsList);
        IngredientListView.setAdapter(adapter);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] ingredients = newIngredienteditText.getText().toString().split(",");
                for(String i: ingredients){
                    LoginActivity.u.addIngredients(i);
                    ingredientItemsList.add(i);
                    adapter.notifyDataSetChanged();
                }
                databaseUsers.child(userID).child("ingredients").child("").setValue(LoginActivity.u.getIngredients());
                newIngredienteditText.setText("");
            };

        });

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_search);
//                Intent searchIntent = new Intent(IngredientActivity.this, SearchActivity.class);
//                Intent intent = getIntent();
//                String userID = intent.getStringExtra("ID");
//                searchIntent.putExtra("ID",userID);
//                startActivity(searchIntent);
            }
        });

        }

}
