package com.erfanatic.datastorageexperiment.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.erfanatic.datastorageexperiment.R;
import com.erfanatic.datastorageexperiment.sharedpreference.ActivityA;

/**
 * Created by erfan on 15-Aug-16.
 */
public class ActivityB extends AppCompatActivity {
        private TextView textUserName;
        private  TextView textPassword;
        private static final String Default ="N/A";
    @Override

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_b);

         textUserName = (TextView) findViewById(R.id.textViewName);
         textPassword = (TextView) findViewById(R.id.textViewPassword);

    }

    public void goToA(View view){
        Intent i = new Intent(this,ActivityA.class);
        startActivity(i);

    }

    public void loadData(View view){

        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("username",Default);
        String pass = sharedPreferences.getString("password",Default);

        if(name.equals(Default)|| pass.equals(Default)){
            Toast.makeText(this,"No Data Was Found",Toast.LENGTH_LONG).show();
        }
        else{
            textUserName.setText(name);
            textPassword.setText(pass);

        }


    }
}
