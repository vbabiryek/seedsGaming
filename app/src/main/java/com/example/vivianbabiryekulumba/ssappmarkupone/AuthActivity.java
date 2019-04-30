package com.example.vivianbabiryekulumba.ssappmarkupone;

import android.app.Activity;
import android.content.Intent;
import android.os.Debug;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.vivianbabiryekulumba.ssappmarkupone.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class AuthActivity extends Activity {

    //    private ProgressBar progressBar;
    final String TAG = "AuthActivity";
    private FirebaseAuth mAuth;
    private EditText emailEditText, passwordEditText;
    Button registerUser;
    Button loginUser;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

//        progressBar = findViewById(R.id.progress_bar);
        emailEditText = findViewById(R.id.auth_email);
        passwordEditText = findViewById(R.id.auth_password);

        mAuth = FirebaseAuth.getInstance();

        registerUser = findViewById(R.id.register_btn);
        loginUser = findViewById(R.id.login_btn);

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {
            //handle the already logged in user
        }
    }

    private void signInUser() {

        final String email = emailEditText.getText().toString().trim();
        final String password = passwordEditText.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, password);
        if(task.isCanceled()){
            Log.e(TAG, "SignInWithEmailAndPasswordAsync was cancelled.");
            return;
        }
        if(!task.isSuccessful()) {
            Log.e(TAG, "SignInWithEmailAndPasswordAsync encountered an error: " + task.getException());
            return;
        }else{
            Toast.makeText(AuthActivity.this, "User successfully signed in!", Toast.LENGTH_LONG).show();
        }
    }

    private void registerUser() {
        final String email = emailEditText.getText().toString().trim();
        final String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty()) {
            emailEditText.setError(getString(R.string.input_error_email));
            emailEditText.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError(getString(R.string.input_error_email_invalid));
            emailEditText.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordEditText.setError(getString(R.string.input_error_password));
            passwordEditText.requestFocus();
            return;
        }

        if (password.length() < 6) {
            passwordEditText.setError(getString(R.string.input_error_password_length));
            passwordEditText.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            User user = new User(
                                    email,
                                    password
                            );

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AuthActivity.this, getString(R.string.registration_success), Toast.LENGTH_LONG).show();
                                    } else {
                                        //display a failure message
                                        Toast.makeText(AuthActivity.this, "Failed to register", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                        } else {
                            Toast.makeText(AuthActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}
