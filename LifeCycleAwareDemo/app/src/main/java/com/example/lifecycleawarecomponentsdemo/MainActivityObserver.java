package com.example.lifecycleawarecomponentsdemo;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;


/**
 * Observer for our MainActivity
 * **/
public class MainActivityObserver implements LifecycleObserver {
    //Tag for displaying logs
    private String TAG=this.getClass().getSimpleName();

    //to keep track of lifecycle events
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateEvent(){
        //Can perform any action over here for now it is displaying log
        Log.i(TAG,"observer ON CREATE");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(){
        //Can perform any action over here for now it is displaying log
        Log.i(TAG,"observer ON START");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        //Can perform any action over here for now it is displaying log
        Log.i(TAG,"observer ON RESUME");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pnPause(){
        //Can perform any action over here for now it is displaying log
        Log.i(TAG,"observer ON PAUSE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDest(){
        //Can perform any action over here for now it is displaying log
        Log.i(TAG,"observer ON DESTROY");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStp(){
        //Can perform any action over here for now it is displaying log
        Log.i(TAG,"observer ON STOP");
    }


}
