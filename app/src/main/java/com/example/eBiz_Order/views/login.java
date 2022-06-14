package com.example.eBiz_Order.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eBiz_Order.R;
import com.example.eBiz_Order.RegisterUser;
import com.example.eBiz_Order.forget_password;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener {

    private TextView register, forgetpassword;
    private EditText editTextTextEmailAddress, editTextTextPassword;
    private Button loginbtn;

    private FirebaseAuth mAuth;
    private ProgressBar progressbar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(this);

        loginbtn = (Button) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(this);

        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);

        progressbar4 = (ProgressBar) findViewById(R.id.progressBar4);

        mAuth = FirebaseAuth.getInstance();

        forgetpassword = (TextView) findViewById(R.id.forgetpw);
        forgetpassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                startActivity(new Intent(this, RegisterUser.class));
                break;

            case R.id.loginbtn:
                userLogin();
                break;

            case R.id.forgetpw:
                startActivity(new Intent(this, forget_password.class));
                break;
        }
    }

    private void userLogin() {
        String email = editTextTextEmailAddress.getText().toString().trim();
        String password = editTextTextPassword.getText().toString().trim();

        if(email.isEmpty()){
            editTextTextEmailAddress.setError("Email is required!");
            editTextTextEmailAddress.requestFocus();
            return;
        }

        if (password.isEmpty()){
            editTextTextPassword.setError("Password is required!");
            editTextTextPassword.requestFocus();
            return;
        }

        progressbar4.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    //redirect to user profile
                    startActivity(new Intent(login.this, MainActivity.class));

                }else{
                    Toast.makeText(login.this, "Failed to login!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}