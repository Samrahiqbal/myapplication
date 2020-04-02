package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Main4Activity extends AppCompatActivity {
    private TextInputEditText ename;
    private TextInputEditText eage;
    RadioGroup egender;
    RadioButton m, f, t;
    private TextInputEditText edob;
    private TextInputEditText emob;
    private TextInputEditText epin;
    private TextInputEditText email;
    private TextInputEditText ep1;
    Button reg;
    String uname, uage, gender, udob, umob, upin, umail, ups;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ename = (TextInputEditText) findViewById(R.id.name);
        eage = (TextInputEditText) findViewById(R.id.txtage);
        egender = (RadioGroup) findViewById(R.id.rd);
        m = (RadioButton) findViewById(R.id.rd1);
        f = (RadioButton) findViewById(R.id.rd2);
        t = (RadioButton) findViewById(R.id.rd3);
        edob = (TextInputEditText) findViewById(R.id.date);
        emob = (TextInputEditText) findViewById(R.id.mobile);
        epin = (TextInputEditText) findViewById(R.id.pin);
        email = (TextInputEditText) findViewById(R.id.txtmail);
        ep1 = (TextInputEditText) findViewById(R.id.password);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();

            }
        });
    }

    public void register() {
        initialize();
        onchecked();
        validate();
        if (!validate()) {
            Toast.makeText(this, "Registeration Failed", Toast.LENGTH_LONG).show();
        } else {
            onSignup();
        }
    }

    public void onchecked() {
        if (egender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please select gender", Toast.LENGTH_LONG).show();
        } else {
            RadioButton selectedRadioButton = findViewById(egender.getCheckedRadioButtonId());
            gender = selectedRadioButton == null ? " " : selectedRadioButton.getText().toString().trim();
        }


    }

    public boolean validate() {
        boolean valid = true;
        String pattern = "[a - zA - ZO - 9._-]+@[a - z]+\\.+[a - z]+";
        String dtpatt = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\\\d\\\\d)\n";
        if (uname.isEmpty() || uname.length() > 50) {
            ename.setError("Please enter valid name");
            valid = false;
        }
        if (uage.isEmpty() || uage.length() > 100) {
            eage.setError("Please enter valid age");
            valid = false;
        }
        if (egender.getCheckedRadioButtonId() == -1) {
            valid = false;
        }
        if (udob.isEmpty() || !udob.matches(dtpatt)) {
            edob.setError("Please enter valid age");
            valid = false;
        }
        if (umob.isEmpty() || umob.length() > 10 || umob.length() < 10) {
            emob.setError("Please enter valid mobile number");
            valid = false;
        }
        if (upin.isEmpty() || upin.length() > 6 || upin.length() < 6) {
            epin.setError("Please enter valid pincode");
            valid = false;
        }
        if (umail.isEmpty() || !umail.matches(pattern)) {
            email.setError("Please Enter valid email");
            valid = false;
        }
        if (ups.isEmpty() || ups.length() > 8) {
            ep1.setError("Enter valid password");
            valid = false;
        }
        return valid;
    }

    public void onSignup() {
        Toast.makeText(getApplicationContext(), "Registeration Succesful", Toast.LENGTH_SHORT).show();
        Intent its = new Intent(Main4Activity.this, MainActivity.class);
        startActivity(its);

    }


    public void initialize() {
        uname = ename.getEditableText().toString().trim();
        uage = eage.getEditableText().toString().trim();
        udob = edob.getEditableText().toString().trim();
        umob = emob.getEditableText().toString().trim();
        upin = epin.getEditableText().toString().trim();
        umail = email.getEditableText().toString().trim();
        ups = ep1.getEditableText().toString().trim();


        String pattern = "[a - zA - ZO - 9._-]+@[a - z]+\\.+[a - z]+";
        String dtpatt = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\\\d\\\\d)\n";
    }
}
