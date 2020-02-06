package com.example.android.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class SecondActivity extends AppCompatActivity implements Serializable {
    String name, address, age, phone, gender, marital, addiction, dob, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        SecondActivity Second = (SecondActivity) intent.getSerializableExtra("object");

        TextView pname=findViewById(R.id.patientname1);
        pname.setText(Second.name);

        TextView addr=findViewById(R.id.addressval1);
        addr.setText(Second.address);

        TextView a=findViewById(R.id.ageval1);
        a.setText(Second.age);

        TextView d=findViewById(R.id.dobval1);
        d.setText(Second.dob);

        TextView g=findViewById(R.id.genderval1);
        g.setText(Second.gender);

        TextView m=findViewById(R.id.maritalstats1);
        m.setText(Second.marital);

        TextView p=findViewById(R.id.number1);
        p.setText(Second.phone);

        TextView rt=findViewById(R.id.time1);
        rt.setText(Second.time);

        TextView ad=findViewById(R.id.add1);
        ad.setText(Second.addiction);
    }
}
