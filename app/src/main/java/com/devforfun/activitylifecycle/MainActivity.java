package com.devforfun.activitylifecycle;

import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * Class used as example for understanding Activity lifecycle
 * 1. Explain the lifecycle
 * 2. Explain the edge cases - eg. onDestroy not called
 * 3. Explain the behaviour of an AsyncTask inside of lifecycle
 * 4.
 * */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MyAsyncTask myAsyncTask;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logger("onCreate()");

        myAsyncTask = new MyAsyncTask(textView);
        textView = (TextView) findViewById(R.id.text);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logger("onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logger("onRestoreInstanceState()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        logger("onStart()");
        myAsyncTask.execute();
    }

    @Override
    protected void onResume() {
        super.onResume();
        logger("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logger("onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logger("onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logger("onStop()");
        myAsyncTask.cancel(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logger("onDestroy()");
    }

    private void logger(String message) {
        Log.d(TAG, message);
    }
}
