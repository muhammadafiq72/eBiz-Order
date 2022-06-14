package com.example.eBiz_Order.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eBiz_Order.R;
import com.example.eBiz_Order.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    private Button logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageButton imageButton=findViewById(R.id.homebtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(profile.this,MainActivity.class);
                startActivity(intent);

            }
        });

                logout = (Button) findViewById(R.id.signout);

                logout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(profile.this,login.class));



            }
        });
                user = FirebaseAuth.getInstance().getCurrentUser();
                reference = FirebaseDatabase.getInstance().getReference("User");
                userID = user.getUid();

                final TextView fullNameTextView = (TextView) findViewById(R.id.fullnameempty);
                final TextView emailTextView = (TextView) findViewById(R.id.emailempty);
                final TextView addressTextView = (TextView) findViewById(R.id.addressempty);
                final TextView phoneTextView = (TextView) findViewById(R.id.phoneempty);

                reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        User userProfile = snapshot.getValue(User.class);

                        if(userProfile !=null){
                            String fullName = userProfile.fullname;
                            String email = userProfile.email;
                            String address = userProfile.address;
                            String phone = userProfile.phone;

                            fullNameTextView.setText(fullName);
                            emailTextView.setText(email);
                            addressTextView.setText(address);
                            phoneTextView.setText(phone);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(profile.this,"Something wrong happened!", Toast.LENGTH_LONG).show();

                    }
                });



    }
}