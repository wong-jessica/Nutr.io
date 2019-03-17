package com.example.cs125_nutrigainsofficial;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity{

    private FirebaseAuth mAuth;
    private EditText mEmailView;
    private EditText mPasswordView;
    private EditText mName;
    private EditText mAge;
    private EditText mGender;

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

        mEmailView = (EditText) findViewById(R.id.email_register);
        mPasswordView = (EditText) findViewById(R.id.password_register);
        mName = (EditText) findViewById(R.id.name);
        mAge = (EditText) findViewById(R.id.age);
        mGender = (EditText) findViewById(R.id.gender);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_register_button);
        Button mLeadToSignInButton = (Button) findViewById(R.id.lead_to_sign_in);

        mLeadToSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_login);
                updateUI(currentUser);

            }
        });

        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(mEmailView.getText().toString(), mPasswordView.getText().toString())
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("Success", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    System.out.println(user.getEmail());
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("Failure", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }

                                // ...
                            }
                        });
            }
        });


    }

    private void updateUI(final FirebaseUser currentUser) {
        if(currentUser == null){
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
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        updateUI(user);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w("Failure ", "signInWithEmail:failure", task.getException());
                                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        updateUI(null);
                                    }

                                    // ...
                                }
                            });
                }
            });

        }
        else{
            /*
            setContentView(R.layout.activity_search);
            Button mEmailSignOutButton = (Button) findViewById(R.id.sign_out_button);
            mEmailSignOutButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    mAuth.signOut();
                    //System.out.println(mAuth.getCurrentUser().getEmail());
                    setContentView(R.layout.activity_login);
                    updateUI(mAuth.getCurrentUser());
                }
            });
        */
            setContentView(R.layout.activity_ingredient);
        }
    }

}