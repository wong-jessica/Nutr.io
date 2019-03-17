package com.example.cs125_nutrigainsofficial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class IngredientActivity extends AppCompatActivity {
    ArrayList<String> ingredientItemsList =new ArrayList<>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient);
    }

    @Override
     protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_ingredient);

        final EditText newIngredienteditText = findViewById(R.id.newIngredienteditText);
        ListView IngredientListView = findViewById(R.id.IngredietListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ingredientItemsList);
        IngredientListView.setAdapter(adapter);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientItemsList.add(newIngredienteditText.getText().toString());
                adapter.notifyDataSetChanged();
                System.out.println("Here");
            };

        });
     }
}
