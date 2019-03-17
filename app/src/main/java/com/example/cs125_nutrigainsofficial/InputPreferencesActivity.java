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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InputPreferencesActivity extends AppCompatActivity{

    private FirebaseAuth mAuth;
    private EditText mAllergies;
    private EditText mDietChoice;
    private EditText mLikes;
    private EditText mDislikes;
    private EditText mReligious;

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
                        getPreferences();
                    }
                });
            }
        });
    }

    public void getPreferences(){
        Intent intent = getIntent();
        String userID = intent.getStringExtra("ID");
        String[] allergies = mAllergies.getText().toString().split(",");
        for(String m: allergies){
            LoginActivity.u.addAllergies(m);
        }
        LoginActivity.u.addDietChoice(mDietChoice.getText().toString());
        String[] likes = mLikes.getText().toString().split(",");
        for(String m: likes){
            LoginActivity.u.addLikes(m);
        }

        String[] dislikes = mLikes.getText().toString().split(",");
        for(String m: dislikes){
            LoginActivity.u.addDislikes(m);
        }
        LoginActivity.u.addReligious(mReligious.getText().toString());

        databaseUsers.child(userID).child("likes").child("").setValue(LoginActivity.u.getLikes());
        databaseUsers.child(userID).child("dislikes").child("").setValue(LoginActivity.u.getDislikes());
        databaseUsers.child(userID).child("dietChoice").child("").setValue(LoginActivity.u.getDietChoice());
        databaseUsers.child(userID).child("allergies").child("").setValue(LoginActivity.u.getAllergies());
        databaseUsers.child(userID).child("religious").child("").setValue(LoginActivity.u.getReligious());
    }
}
