package com.example.eBiz_Order.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eBiz_Order.R;

public class payment_option extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);

        Button button=findViewById(R.id.buttoncreditcard);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(payment_option.this,credit_debit_payment.class);
                startActivity(intent);

            }
        });

        button = findViewById(R.id.buttononlinebanking);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(payment_option.this,online_payment.class);
                startActivity(intent);

            }
        });
    }
}