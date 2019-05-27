package com.example.livedatademo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private String TAG=this.getClass().getSimpleName();
    private MutableLiveData<String> myRandomNumber;


    public MutableLiveData<String> getNumber(){
        Log.i(TAG,"Get Number");
        if(myRandomNumber==null){
            myRandomNumber=new MutableLiveData<>();
            createNumber();
        }
        return myRandomNumber;
    }

    public void createNumber(){
        Log.i(TAG,"Create new Number");
        Random random=new Random();
        myRandomNumber.setValue("Number: "+ (random.nextInt(10 -1)+1));
    }

    @Override
    protected void onCleared(){
        super.onCleared();
        Log.i(TAG,"ViewModel Destroyed");
    }

}
