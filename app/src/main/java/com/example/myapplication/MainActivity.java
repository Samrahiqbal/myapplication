package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.net.PasswordAuthentication;

public class MainActivity extends AppCompatActivity {
    Button bt1, bt2, bt3;
    private TextInputEditText et1, et2;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (TextInputEditText) findViewById(R.id.e1);
        et2 = (TextInputEditText) findViewById(R.id.e2);
        bt1 = (Button) findViewById(R.id.b1);
        bt2 = (Button) findViewById(R.id.b3);
        bt3 = (Button) findViewById(R.id.b2);
        tv = (TextView) findViewById(R.id.tv);

        String text = "Forgot Password?Click Here";
        SpannableString ss = new SpannableString(text);
        ClickableSpan click1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
            }

        };
        ss.setSpan(click1, 16, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        bt1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et1.getEditableText().toString().trim();
                String psd = et2.getEditableText().toString().trim();

                String pattern = "[a - zA - ZO - 9._-]+@[a - z]+\\.+[a - z]+";
                if (email.matches(pattern) && psd.length() <= 8) {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                } else {
                    if (psd.length() < 8 || psd.length() > 8) {
                        et2.setError("Please enter correct password");
                        Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_LONG).show();
                    } else {
                        et1.setError("Please enter valid username");
                        Toast.makeText(getApplicationContext(), "Invalid Email address", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        bt3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(i1);

            }
        });
    }

}



