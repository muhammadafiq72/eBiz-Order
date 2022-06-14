package com.example.eBiz_Order;

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

import com.example.eBiz_Order.views.login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private TextView banner, RegisterUser;
    private EditText editTextTextPersonName, editTextTextPersonName2, editTextTextEmailAddress2, editTextTextPassword2, editTextPhone2;
    private ProgressBar progressBar5;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        RegisterUser = (Button) findViewById(R.id.RegisterUser);
        RegisterUser.setOnClickListener(this);

        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        editTextTextEmailAddress2 =(EditText) findViewById(R.id.editTextTextEmailAddress2);
        editTextTextPassword2 =(EditText) findViewById(R.id.editTextTextPassword2);
        editTextPhone2 =(EditText) findViewById(R.id.editTextPhone2);

        progressBar5 = (ProgressBar) findViewById(R.id.progressBar5);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner:
                startActivity(new Intent(this, login.class));
                break;
            case R.id.RegisterUser:
                RegisterUser();
                break;
        }

    }

    private void RegisterUser() {
        String email=editTextTextEmailAddress2.getText().toString().trim();
        String password=editTextTextPassword2.getText().toString().trim();
        String fullname=editTextTextPersonName.getText().toString().trim();
        String address=editTextTextPersonName2.getText().toString().trim();
        String phone =editTextPhone2.getText().toString().trim();

        if (fullname.isEmpty()){
            editTextTextPersonName.setError("Full name is required");
            editTextTextPersonName.requestFocus();
            return;
        }

        if (address.isEmpty()){
            editTextTextPersonName2.setError("Address is required");
            editTextTextPersonName2.requestFocus();
            return;
        }

        if (email.isEmpty()){
            editTextTextEmailAddress2.setError("Email is required");
            editTextTextEmailAddress2.requestFocus();
            return;
        }



        if (password.isEmpty()){
            editTextTextPassword2.setError("Password is required");
            editTextTextPassword2.requestFocus();
            return;
        }

        if (phone.isEmpty()){
            editTextPhone2.setError("Phone number is required");
            editTextPhone2.requestFocus();
            return;
        }

        progressBar5.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            User user = new User(fullname, address, email, phone);

                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(RegisterUser.this, "User has been regiestered succesfully!", Toast.LENGTH_LONG).show();
                                        progressBar5.setVisibility(View.VISIBLE);




                                    }else{
                                        Toast.makeText(RegisterUser.this, "Failed to register user!", Toast.LENGTH_LONG).show();
                                        progressBar5.setVisibility(View.GONE);
                                    }

                                }
                            });
                        }else{
                            Toast.makeText(RegisterUser.this, "Failed to register user!", Toast.LENGTH_LONG).show();
                            progressBar5.setVisibility(View.GONE);
                        }

                    }
                });

    }
}