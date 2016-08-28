package com.erfanatic.datastorageexperiment.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.erfanatic.datastorageexperiment.R;

/**
 * Created by erfan on 28-Aug-16.
 */
public class StorePrimitive extends AppCompatActivity{
    private Switch mySwitch;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primitive_store);

        mySwitch = (Switch) findViewById(R.id.switch1);

        sharedPreferences = getSharedPreferences("stateFile", MODE_PRIVATE);
        boolean state = sharedPreferences.getBoolean("state",false);
        mySwitch.setChecked(state);

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                sharedPreferences = getSharedPreferences("stateFile", MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putBoolean("state",isChecked);
                editor.commit();
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();


    }

}