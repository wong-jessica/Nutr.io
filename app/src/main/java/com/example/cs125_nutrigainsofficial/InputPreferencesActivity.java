package com.example.cs125_nutrigainsofficial;

//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

        import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.FirebaseApp;

        import com.google.firebase.auth.FirebaseAuth;

public class InputPreferencesActivity extends AppCompatActivity{

    private FirebaseAuth mAuth;

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

        Button mNext1 = (Button) findViewById(R.id.next_button1);
        mNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_inputpreferences2);
            }
        });
    }
}
