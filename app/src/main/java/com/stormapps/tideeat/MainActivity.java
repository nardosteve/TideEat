package com.stormapps.tideeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button btnSignUp;
    public Button btnSignIn;
    public TextView txtSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        txtSlogan = (TextView) findViewById(R.id.txtSlogan);
        //Get font from the Asset folder
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/NABILA.TTF");

        //Set an ActionListener to the Buttons (Signin and Signup)
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Adding an Intent to change activities
                Intent SignIn = new Intent(MainActivity.this, SignIn.class);
                startActivity(SignIn);
            }
        });

    }
}