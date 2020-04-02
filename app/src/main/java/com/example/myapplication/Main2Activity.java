package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Main2Activity extends AppCompatActivity {
    private TextInputEditText em;
    Button sot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        em = (TextInputEditText) findViewById(R.id.editText);
        sot = (Button) findViewById(R.id.button);

        sot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em2=em.getEditableText().toString().trim();
                String pattern="[a - zA - ZO - 9._-]+@[a - z]+\\.+[a - z]+";

                if(em2.matches(pattern))
                {
                    Intent it2=new Intent(Main2Activity.this,otp.class);
                    startActivity(it2);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Email",Toast.LENGTH_LONG).show();

                }
            }
        });


    }}