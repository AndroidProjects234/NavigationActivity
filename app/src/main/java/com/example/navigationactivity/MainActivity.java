package com.example.navigationactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] names = {"Apples and Bacon","Thread"};
        Integer[]images={R.drawable.apple_icon,R.drawable.images};
        //This converts array into a basic list
        // ListAdapter buckysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        ListAdapter buckysAdapter = new CustomAdapter(this, names,images);
        ListView buckysListView=(ListView)findViewById(R.id.buckysListView);
        buckysListView.setAdapter(buckysAdapter);   //set adapter to listview
        buckysListView.setOnItemClickListener(  //set listener to list
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item=String.valueOf(parent.getItemAtPosition(position)); //get value related to that particular id
                        switch (item){
                            case "Apples and Bacon":
                                Intent i=new Intent(MainActivity.this,Apples.class);
                                startActivity(i);
                                break;
                            case "Thread":
                                Intent i1=new Intent(MainActivity.this,Threads.class);
                                startActivity(i1);
                                break;


                        }
                        //Toast.makeText(MainActivity.this,food, Toast.LENGTH_SHORT).show();

                    }
                }
        );


    }


}
