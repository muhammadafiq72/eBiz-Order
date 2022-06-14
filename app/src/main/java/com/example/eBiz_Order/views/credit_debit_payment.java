package com.example.eBiz_Order.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eBiz_Order.R;

public class credit_debit_payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_debit_payment);

        Button button=findViewById(R.id.buttonpay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(credit_debit_payment.this,thank_you.class);
                startActivity(intent);

            }
        });
    }
}
