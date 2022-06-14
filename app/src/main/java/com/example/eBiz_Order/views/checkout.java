package com.example.eBiz_Order.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class checkout extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Button button=findViewById(R.id.buttoncontinuepayment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(checkout.this,payment_option.class);
                startActivity(intent);

            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("User");
        userID = user.getUid();

        final TextView fullNameTextView = (TextView) findViewById(R.id.fullnameempty2);
        final TextView emailTextView = (TextView) findViewById(R.id.emailempty2);
        final TextView addressTextView = (TextView) findViewById(R.id.addressempty2);
        final TextView phoneTextView = (TextView) findViewById(R.id.phoneempty2);

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
                Toast.makeText(checkout.this,"Something wrong happened!", Toast.LENGTH_LONG).show();

            }
        });
    }
}