package com.example.android.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity  {
    SecondActivity second= new SecondActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner=findViewById(R.id.maritalstats);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.marital_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText pn=findViewById(R.id.patientname);
                second.name=pn.getText().toString();

                EditText av=findViewById(R.id.addressval);
                second.address=av.getText().toString();

                EditText ag=findViewById(R.id.ageval);
                second.age=ag.getText().toString();

                DatePicker d=findViewById(R.id.dobval);
                Integer day=d.getDayOfMonth();
                Integer month=(d.getMonth() + 1);
                Integer year=d.getYear();
                second.dob=day.toString() + "/" + month.toString() + "/" + year.toString();

                RadioGroup r=findViewById(R.id.radiogroup);
                Integer rid=r.getCheckedRadioButtonId();
                RadioButton r1=findViewById(rid);
                second.gender=r1.getText().toString();

                final Spinner s=findViewById(R.id.maritalstats);
                String opt=s.getSelectedItem().toString();
                second.marital=opt;

                EditText ph=findViewById(R.id.number);
                second.phone=ph.getText().toString();

                TimePicker t=findViewById(R.id.time);
                Integer hour=t.getHour();
                Integer min=t.getMinute();
                second.time = hour.toString() + ":" + min.toString();

                CheckBox c1=findViewById(R.id.smokes);
                int flag=0;
                String t1="";
                if(c1.isChecked())
                    t1=c1.getText().toString();
                else
                    flag++;

                CheckBox c2=findViewById(R.id.drinks);
                String t2="";
                if(c2.isChecked())
                    t2 = c2.getText().toString();
                else
                    flag++;
                if(flag != 2)
                    second.addiction = t1+" "+t2;
                else
                    second.addiction = "None";

                Context context = getApplicationContext();
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("object",second);
                startActivity(intent);
                //startActivity(new Intent(MainActivity.this,SecondActivity.class));

            }
        });

        Button reset=findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText pn=findViewById(R.id.patientname);
                pn.setText("");

                EditText av=findViewById(R.id.addressval);
                av.setText("");

                EditText ag=findViewById(R.id.ageval);
                ag.setText("");

                DatePicker d=findViewById(R.id.dobval);
                Calendar c = Calendar.getInstance();
                d.updateDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

                RadioGroup r=findViewById(R.id.radiogroup);
                r.clearCheck();

                final Spinner s=findViewById(R.id.maritalstats);
                s.setSelection(0);

                EditText ph=findViewById(R.id.number);
                ph.setText("");

                TimePicker t=findViewById(R.id.time);
                t.setHour(c.get(Calendar.HOUR_OF_DAY));
                t.setMinute(c.get(Calendar.MINUTE));

                CheckBox c1=findViewById(R.id.smokes);
                c1.setChecked(false);

                CheckBox c2=findViewById(R.id.drinks);
                c2.setChecked(false);

            }
        });


            }
}
