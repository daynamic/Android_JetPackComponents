package com.example.lifecycleawarecomponentsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/***
 * Lifecycle Owner
 * */


public class MainActivity extends AppCompatActivity {

    private String TAG=this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Owner ON_CREATE");

        //Attaching the observer to listen for updates
        getLifecycle().addObserver(new MainActivityObserver());
    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "Owner ON_Start");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "Owner ON_Pause");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "Owner ON_Resume");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "Owner ON_Destroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "Owner ON_Stop");
    }
}
