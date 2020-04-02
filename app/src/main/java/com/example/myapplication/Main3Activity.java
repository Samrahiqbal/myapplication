package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Main3Activity extends AppCompatActivity {
    private TextInputEditText ps1,ps2;
    Button sbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ps1=(TextInputEditText) findViewById(R.id.editText2);
        ps2=(TextInputEditText) findViewById(R.id.editText3);
        sbt=(Button)findViewById(R.id.button2);

        sbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password1=ps1.getEditableText().toString();
                String password2=ps2.getEditableText().toString();
                if(password2.matches(password1))
                {
                    Intent it4=new Intent(Main3Activity.this,MainActivity.class);
                    startActivity(it4);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Password mismatched",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
