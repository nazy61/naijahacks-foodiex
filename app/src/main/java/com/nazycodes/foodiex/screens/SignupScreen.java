package com.nazycodes.foodiex.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class SignupScreen extends AppCompatActivity {

    private MaterialButton btnLogin;
    private MaterialButton btnSignUp;
    private TextInputEditText email;
    private TextInputEditText username;
    private TextInputEditText password;
    private TextInputEditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        btnLogin = findViewById(R.id.login);
        btnSignUp = findViewById(R.id.signUpButton);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(email.getText().toString().isEmpty()){
                    Toast.makeText(SignupScreen.this, "Please Enter an Email Address", Toast.LENGTH_LONG).show();
                } else if(username.getText().toString().isEmpty()){
                    Toast.makeText(SignupScreen.this, "Please Enter Username", Toast.LENGTH_LONG).show();
                } else if(password.getText().toString().isEmpty()){
                    Toast.makeText(SignupScreen.this, "Please Enter your Password", Toast.LENGTH_LONG).show();
                } else if(confirmPassword.getText().toString().isEmpty()){
                    Toast.makeText(SignupScreen.this, "Please Enter your password in the confirm password field", Toast.LENGTH_LONG).show();
                } else if(!password.getText().toString().equals(confirmPassword.getText().toString())){
                    Toast.makeText(SignupScreen.this, "Password do not match", Toast.LENGTH_LONG).show();
                } else {
                    Firebase.auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Intent intent = new Intent(SignupScreen.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(SignupScreen.this, task.getException().toString(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupScreen.this, LoginScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
