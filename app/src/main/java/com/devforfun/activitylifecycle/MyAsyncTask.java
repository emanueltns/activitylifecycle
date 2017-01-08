package com.devforfun.activitylifecycle;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Emanuel on 1/6/2017.
 *
 */

public class MyAsyncTask extends AsyncTask<Void, Void, Void> {

    private final TextView textView;

    public MyAsyncTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected Void doInBackground(Void[] params) {
        for (int i = 0; i < 100000; i++){
            Log.d("Async", "doInBackground()");
            if(isCancelled()) {
                break;
            }
        }
        return null;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d("Async", "onCancelled()");
    }

    @Override
    protected void onPostExecute(Void o) {
        if (isCancelled()) {
            Log.d("Aync", "isCanceled() - do nothing");
        } else {
            textView.setText("Ceva");
        }
    }
}
