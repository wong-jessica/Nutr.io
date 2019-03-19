package com.example.cs125_nutrigainsofficial;

//import android.support.design.widget.Snackbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InputPreferencesActivity extends AppCompatActivity{

    private FirebaseAuth mAuth;
    private EditText mAllergies;
    private EditText mDietChoice;
    private EditText mLikes;
    private EditText mDislikes;
    private EditText mReligious;
    private EditText mMinFat,mMaxFat,mMinFiber,mMaxFiber,mMinSodium,mMaxSodium,mMinCalories,mMaxCalories,mMinCarbs,mMaxCarbs,mMinSugar,mMaxSugar;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseUsers = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputpreferences1);
        FirebaseApp.initializeApp(InputPreferencesActivity.this);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart(){
        super.onStart();
        mAllergies = findViewById(R.id.input_allergies);
        mDietChoice = findViewById(R.id.input_diet);
        Button mNext1 = (Button) findViewById(R.id.next_button1);
        mNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_inputpreferences2);
                mLikes = findViewById(R.id.input_likes);
                mDislikes = findViewById(R.id.input_dislikes);
                mReligious = findViewById(R.id.input_religious);
                Button mNext2 = (Button) findViewById(R.id.next_button2);
                mNext2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.activity_inputpreferences3);
                        mMinFat = findViewById(R.id.min_fat);
                        mMaxFat = findViewById(R.id.max_fat);
                        mMinFiber = findViewById(R.id.min_fiber);
                        mMaxFiber = findViewById(R.id.max_fiber);
                        mMinSodium = findViewById(R.id.min_sodium);
                        mMaxSodium = findViewById(R.id.max_sodium);
                        Button mNext3 = (Button) findViewById(R.id.next_button3);
                        mNext3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                setContentView(R.layout.activity_inputpreferences4);
                                mMinCalories = findViewById(R.id.min_calories);
                                mMaxCalories = findViewById(R.id.max_calories);
                                mMinCarbs = findViewById(R.id.min_carbs);
                                mMaxCarbs = findViewById(R.id.max_carbs);
                                mMinSugar = findViewById(R.id.min_sugar);
                                mMaxSugar = findViewById(R.id.max_sugar);
                                Button mNext4 = (Button) findViewById(R.id.next_button4);
                                mNext4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        getPreferences();
                                        Intent ingredientIntent = new Intent(InputPreferencesActivity.this, IngredientActivity.class);
                                        Intent intent = getIntent();
                                        String userID = intent.getStringExtra("ID");
                                        ingredientIntent.putExtra("ID",userID);
                                        startActivity(ingredientIntent);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }

    public void getPreferences(){
        //Intent intent = getIntent();
        //String userID = intent.getStringExtra("ID");
        String[] allergies = mAllergies.getText().toString().split(",");
        for(String m: allergies){
            LoginActivity.u.addAllergies(m);
        }
        LoginActivity.u.addDietChoice(mDietChoice.getText().toString());
        String[] likes = mLikes.getText().toString().split(",");
        for(String m: likes){
            LoginActivity.u.addLikes(m);
        }

        String[] dislikes = mDislikes.getText().toString().split(",");
        for(String m: dislikes){
            LoginActivity.u.addDislikes(m);
        }

        String[] religious = mReligious.getText().toString().split(",");
        for(String m: religious){
            LoginActivity.u.addReligious(m);
        }

        try {
            if (mMinFat.getText().toString().trim() != "") {
                LoginActivity.u.getFat().set(0, Integer.parseInt(mMinFat.getText().toString().trim()));
                LoginActivity.u.getFat().set(1, Integer.parseInt(mMaxFat.getText().toString().trim()));
            }

            if (mMinCarbs.getText().toString().trim() != "") {
                LoginActivity.u.getCarbs().set(0, Integer.parseInt(mMinCarbs.getText().toString().trim()));
                LoginActivity.u.getCarbs().set(1, Integer.parseInt(mMaxCarbs.getText().toString().trim()));
            }

            if (mMinSugar.getText().toString().trim() != "") {
                LoginActivity.u.getSugar().set(0, Integer.parseInt(mMinSugar.getText().toString().trim()));
                LoginActivity.u.getSugar().set(1, Integer.parseInt(mMaxSugar.getText().toString().trim()));
            }

            if (mMinSodium.getText().toString().trim() != "") {
                LoginActivity.u.getSodium().set(0, Integer.parseInt(mMinSodium.getText().toString().trim()));
                LoginActivity.u.getSodium().set(1, Integer.parseInt(mMaxSodium.getText().toString().trim()));
            }

            if (mMinCalories.getText().toString().trim() != "") {
                LoginActivity.u.getCalories().set(0, Integer.parseInt(mMinCalories.getText().toString().trim()));
                LoginActivity.u.getCalories().set(1, Integer.parseInt(mMaxCalories.getText().toString().trim()));
            }

            if (mMinFiber.getText().toString().trim() != "") {
                LoginActivity.u.getFiber().set(0, Integer.parseInt(mMinFiber.getText().toString().trim()));
                LoginActivity.u.getFiber().set(1, Integer.parseInt(mMaxFiber.getText().toString().trim()));
            }
        }
        catch (Exception e){

        }

        FirebaseUser user = mAuth.getCurrentUser();
        databaseUsers.child(user.getUid()).child("fat").child("").setValue(LoginActivity.u.getFat());
        databaseUsers.child(user.getUid()).child("fiber").child("").setValue(LoginActivity.u.getFiber());
        databaseUsers.child(user.getUid()).child("sodium").child("").setValue(LoginActivity.u.getSodium());
        databaseUsers.child(user.getUid()).child("calories").child("").setValue(LoginActivity.u.getCalories());
        databaseUsers.child(user.getUid()).child("carbs").child("").setValue(LoginActivity.u.getCarbs());
        databaseUsers.child(user.getUid()).child("sugar").child("").setValue(LoginActivity.u.getSugar());
        databaseUsers.child(user.getUid()).child("likes").child("").setValue(LoginActivity.u.getLikes());
        databaseUsers.child(user.getUid()).child("dislikes").child("").setValue(LoginActivity.u.getDislikes());
        databaseUsers.child(user.getUid()).child("dietChoice").child("").setValue(LoginActivity.u.getDietChoice());
        databaseUsers.child(user.getUid()).child("allergies").child("").setValue(LoginActivity.u.getAllergies());
        databaseUsers.child(user.getUid()).child("religious").child("").setValue(LoginActivity.u.getReligious());
    }
}
