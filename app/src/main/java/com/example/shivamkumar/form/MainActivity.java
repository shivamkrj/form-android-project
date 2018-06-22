package com.example.shivamkumar.form;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText editText;
    EditText editText2;
    String name;
    String ag;
    int x=0;
    boolean first=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences =getSharedPreferences("my_shared_pref",MODE_PRIVATE);
        boolean first=sharedPreferences.getBoolean("FIRST",false);
        if(first){
            name=sharedPreferences.getString("NAME",null);
            int age= sharedPreferences.getInt("AGE",0);
            x= sharedPreferences.getInt("GENDER",0);

            editText=(EditText)findViewById(R.id.name);
            editText2=(EditText)findViewById(R.id.age);

            RadioButton radioButtonMale = findViewById(R.id.male);
            RadioButton radioButtonFeMale = findViewById(R.id.female);
            RadioButton radioButtonOther = findViewById(R.id.other);

            editText.setText(name);
            editText2.setText(age+"");
            if(x==1){
                radioButtonMale.setChecked(true);
            }else if(x==2){
                radioButtonFeMale.setChecked(true);
            }else if(x==3){
                radioButtonOther.setChecked(true);
            }

        }


    }
    public void next(View view){
        Intent intent= new Intent(this,NewActivity.class);

        editText=(EditText)findViewById(R.id.name);
        editText2=(EditText)findViewById(R.id.age);

        RadioButton radioButtonMale = findViewById(R.id.male);
        RadioButton radioButtonFeMale = findViewById(R.id.female);
        RadioButton radioButtonOther = findViewById(R.id.other);

        if(radioButtonMale.isChecked()){
            x=1;
        }else if(radioButtonFeMale.isChecked())
            x=2;
        else if (radioButtonOther.isChecked())
            x=3;

        name=editText.getText().toString();
        ag= editText2.getText().toString();

        int age= Integer.parseInt(ag);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME",name);
        editor.putBoolean("FIRST",true);
        editor.putInt("AGE",age);
        editor.putInt("GENDER",x);
        editor.commit();

        intent.putExtra("AGE",age);
        intent.putExtra("NAME",name);
        intent.putExtra("GENDER",x);
        startActivity(intent);
    }
}
