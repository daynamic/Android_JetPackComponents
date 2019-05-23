package com.example.viewmodeldemo;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private String TAG=this.getClass().getSimpleName();
    private String myRandomNumber;


    public String getNumber(){
        Log.i(TAG,"Get Number");
        if(myRandomNumber==null){
            createNumber();
        }
        return myRandomNumber;
    }

    private void createNumber(){
        Log.i(TAG,"Create new Number");
        Random random=new Random();
        myRandomNumber= "Number: "+ (random.nextInt(10 -1)+1);
    }

    @Override
    protected void onCleared(){
        super.onCleared();
        Log.i(TAG,"ViewModel Destroyed");
    }

}
