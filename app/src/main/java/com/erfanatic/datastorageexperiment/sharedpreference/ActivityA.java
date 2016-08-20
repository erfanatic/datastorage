package com.erfanatic.datastorageexperiment.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.erfanatic.datastorageexperiment.R;

public class ActivityA extends AppCompatActivity {

    TextView username;
    TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        username = (TextView) findViewById(R.id.textViewName);
        password = (TextView) findViewById(R.id.textViewPassword);
    }

    // go To B  Button click method
    public void goToB(View view){

        Intent i = new Intent(this,ActivityB.class);
        startActivity(i);
    }

    //click method to save data
    public void saveData(View view){

        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();


        editor.putString("username", username.getText().toString() );
        editor.putString("password",password.getText().toString());
        editor.commit();
        Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show();
    }
}
