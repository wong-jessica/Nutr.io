package com.example.cs125_nutrigainsofficial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import android.support.design.widget.Snackbar;

public class LoginActivity extends AppCompatActivity{

    private FirebaseAuth mAuth;
    private EditText mEmailView;
    private EditText mPasswordView;
    private EditText mName;
    private EditText mAge;
    private EditText mGender;
    private String userID;
    public static User u;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseUsers = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FirebaseApp.initializeApp(LoginActivity.this);
        mAuth = FirebaseAuth.getInstance();
        //setContentView(R.layout.activity_register);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        final FirebaseUser currentUser = mAuth.getCurrentUser();


        Button mEmailSignInButton = (Button) findViewById(R.id.email_register_button);
        Button mLeadToSignInButton = (Button) findViewById(R.id.lead_to_sign_in);

        mLeadToSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });


    }

    public void createUser(){
        mEmailView = (EditText) findViewById(R.id.email_register);
        mPasswordView = (EditText) findViewById(R.id.password_register);
        mName = (EditText) findViewById(R.id.name);
        mAge = (EditText) findViewById(R.id.age);
        mGender = (EditText) findViewById(R.id.gender);
        mAuth.createUserWithEmailAndPassword(mEmailView.getText().toString(), mPasswordView.getText().toString())
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Success", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            databaseUsers.child("users").setValue(user.getUid());
                            u = new User(user.getUid(),user.getEmail(),mName.getText().toString(),mAge.getText().toString(),mGender.getText().toString());
                            databaseUsers.child(user.getUid()).setValue(u);
//                            databaseUsers.child(userID).child("fat").child("").setValue(u.getFat());
//                            databaseUsers.child(userID).child("fiber").child("").setValue(u.getFiber());
//                            databaseUsers.child(userID).child("sodium").child("").setValue(u.getSodium());
//                            databaseUsers.child(userID).child("calories").child("").setValue(u.getCalories());
//                            databaseUsers.child(userID).child("carbs").child("").setValue(u.getCarbs());
//                            databaseUsers.child(userID).child("sugar").child("").setValue(u.getSugar());
//                            databaseUsers.child(userID).child("ingredients").child("").setValue(u.getIngredients());
//                            databaseUsers.child(userID).child("favorites").child("").setValue(u.getFavorites());


                            updateUI(user,true);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Failure", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            updateUI(null,true);
                        }

                        // ...
                    }
                });
    }

    public void signIn(){
        setContentView(R.layout.activity_login);
        mEmailView = (EditText) findViewById(R.id.email_login);
        mPasswordView = (EditText) findViewById(R.id.password_login);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);

        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signInWithEmailAndPassword(mEmailView.getText().toString(), mPasswordView.getText().toString())
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("Success", "signInWithEmail:success");
                                    final FirebaseUser user = mAuth.getCurrentUser();

                                    updateUI(user,false);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("Failure ", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null,false);
                                }


                            }
                        });
            }
        });
    }

    private void updateUI(final FirebaseUser currentUser, boolean firstTimeUser) {
        if(currentUser == null){
            if(firstTimeUser){
                Button mEmailSignInButton = (Button) findViewById(R.id.email_register_button);
                mEmailSignInButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        createUser();
                    }
                });
            }
            else{
                signIn();
            }
        }
        else{
            if(firstTimeUser){
                goToPreferences();
            }
            else{
//                setContentView(R.layout.activity_search);
                Intent searchIntent = new Intent(LoginActivity.this, SearchActivity.class);
                Intent intent = getIntent();
                String userID = intent.getStringExtra("ID");
                searchIntent.putExtra("ID",userID);
                startActivity(searchIntent);

//                Button mEmailSignOutButton = (Button) findViewById(R.id.sign_out_button);
//                mEmailSignOutButton.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        mAuth.signOut();
//                        //System.out.println(mAuth.getCurrentUser().getEmail());
//                        setContentView(R.layout.activity_login);
//                        updateUI(mAuth.getCurrentUser(),false);
//                    }
//                });
            }
        }
    }

    public void goToPreferences(){
        Intent goToIntent = new Intent(this,InputPreferencesActivity.class);
        //goToIntent.putExtra("ID",userID);
        startActivity(goToIntent);
    }

}