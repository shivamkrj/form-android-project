package com.example.shivamkumar.form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    String name;
    int age=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent=getIntent();
        name= intent.getStringExtra("NAME");
        age=intent.getIntExtra("AGE",0);
        int x= intent.getIntExtra("GENDER",0);

        TextView textView = findViewById(R.id.textViewName);
        TextView textView1 = findViewById(R.id.textViewAge);
        TextView textView2 =findViewById(R.id.textView3);

        if(x==1)
        textView2.setText("male");
        else if(x==2)
            textView2.setText("female");
        else if(x==3)
            textView2.setText("other");

        textView.setText(name);

        textView1.setText(age+"");

    }
}
