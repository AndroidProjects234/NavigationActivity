package com.example.navigationactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class Apples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
    public void onClick(View view){
        Intent i=new Intent(this,Bacon.class);  //creating instance of an intent.Intent is used for switching between the activity
        final EditText applesInput=(EditText)findViewById(R.id.applesInput);
        String userMessage=applesInput.getText().toString();  //toString() converts text into string
        i.putExtra("appleMessage",userMessage);   //It is used when we have some information to send into another activity
                        //putExtra takes input into key,value pair
        startActivity(i);

    }
}
