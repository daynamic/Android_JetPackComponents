package com.example.workmanagerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating a data object and passing it.
        Data data=new Data.Builder()
                .putString(MyWorker.TASK_DESC,"Data passed from MainActivity")
                .build();

        final OneTimeWorkRequest workRequest= new OneTimeWorkRequest.Builder(MyWorker.class).setInputData(data).build();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkManager.getInstance().enqueue(workRequest);
            }
        });


        //Getting the TextView
        final TextView tv=(TextView)findViewById(R.id.textViewStatus);

        //listening to the work status
        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequest.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        //Displaying the status into TextView
                        tv.append(workInfo.getState().name()+ "\n");
                    }
                });
    }
}
