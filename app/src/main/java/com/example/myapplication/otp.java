package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class otp extends AppCompatActivity {
    TextInputEditText otext;
    Button ob1,ob2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        otext=(TextInputEditText) findViewById(R.id.editText8);
        ob1=(Button)findViewById(R.id.button3);
        ob2=(Button)findViewById(R.id.button4);

        ob2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otps=otext.getEditableText().toString().trim();
                if(otps.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Type Correct OTP",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent it3=new Intent(otp.this,Main3Activity.class);
                    startActivity(it3);
                }
            }
        });
    }
}
