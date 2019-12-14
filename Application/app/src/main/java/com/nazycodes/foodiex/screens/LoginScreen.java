package com.nazycodes.foodiex.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.nazycodes.foodiex.MainActivity;
import com.nazycodes.foodiex.R;
import com.nazycodes.foodiex.database.Firebase;

public class LoginScreen extends AppCompatActivity {

    private MaterialButton btnLogin;
    private MaterialButton btnSignUp;
    private TextInputEditText email;
    private TextInputEditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        btnLogin = findViewById(R.id.loginButton);
        btnSignUp = findViewById(R.id.signUpButton);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (email.getText().toString().isEmpty()){
                    Toast.makeText(LoginScreen.this, "Please Enter an Email Address", Toast.LENGTH_LONG).show();
                } else if (password.getText().toString().isEmpty()){
                    Toast.makeText(LoginScreen.this, "Please Enter your Password", Toast.LENGTH_LONG).show();
                } else {
                    Firebase.auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(LoginScreen.this, task.getException().toString(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
//                Intent intent = new Intent(LoginScreen.this, MainActivity.class);
//                startActivity(intent);
//                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, SignupScreen.class);
                startActivity(intent);
            }
        });
    }
}