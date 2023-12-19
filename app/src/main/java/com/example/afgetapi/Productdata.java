package com.example.afgetapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Productdata extends AppCompatActivity {
    TextView tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdata);

        tt = findViewById(R.id.textView);

        try {
            Intent intent = getIntent();
            String str = intent.getStringExtra("product_id");
            String str1 = intent.getStringExtra("product_id");
            String str2 = intent.getStringExtra("product_id");
            String str3 = intent.getStringExtra("product_id");
            tt.setText(str);


        } catch (Exception e) {
            Toast.makeText(Productdata.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
}