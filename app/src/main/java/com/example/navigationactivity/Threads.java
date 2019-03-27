package com.example.navigationactivity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Threads extends AppCompatActivity {

    Handler handler=new Handler(){  //it is responsible for performing operations on interface.Handler is assigning to main thread.
        @Override
        public void handleMessage(Message msg) {
            TextView buckysText=(TextView)findViewById(R.id.buckysText);
            buckysText.setText("Nice job Hoss!");

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void clickBuckysButton(View view){
        Runnable r=new Runnable() { //we cannot change the Textview text into a thread its a bad programming or it crashes ur app
            @Override
            public void run() {
                long futureTime=System.currentTimeMillis() + 10000; //get system current time and increment 10 secs to it
                while(System.currentTimeMillis()<futureTime){
                    synchronized (this){
                        try{
                            wait(futureTime-System.currentTimeMillis());    //Wait for 10 secs and then changes the text
                        }catch (Exception e){ }
                    }
                }
                handler.sendEmptyMessage(0);//calls the handler()
            }
        };
        Thread buckysThread=new Thread(r);
        buckysThread.start();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
