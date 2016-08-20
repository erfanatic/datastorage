package com.erfanatic.datastorageexperiment.database;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.erfanatic.datastorageexperiment.R;

/**
 * Created by erfan on 16-Aug-16.
 */
public class InsertData extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private DbAdapter myDbHelper;

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        username = (EditText) findViewById(R.id.editText_username);
        password = (EditText) findViewById(R.id.editText_password);

         myDbHelper = new DbAdapter(this);
        }

    public void insert(View view){

            String name = username.getText().toString();
            String pass = password.getText().toString();
              long id= myDbHelper.insertData(name,pass);

            if(id<0){

                Toast.makeText(this,"Insert failed",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Row inserted successfully",Toast.LENGTH_SHORT).show();

            }
    }

    public void getData(View view){

        String data = myDbHelper.getAllData();
        Toast.makeText(this,data+"",Toast.LENGTH_LONG).show();
    }
}
