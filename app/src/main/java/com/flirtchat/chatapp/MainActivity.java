package com.flirtchat.chatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d("MethodLifecycle", "onCreate is called");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MethodLifecycle", "onStart is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MethodLifecycle", "onStop is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MethodLifecycle", "onPause is called");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MethodLifecycle", "onResume is called");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MethodLifecycle", "onDestroy is called");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
