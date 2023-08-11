package com.example.myapplicationdemo02;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProgressBarActivity02 extends ComponentActivity {
    private int currentProgress = 0;
    private Handler mHandler;
    private ProgressBar progressBar;
    private int maxProgress;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prograssbar_layout);
        progressBar = findViewById(R.id.pb);
        maxProgress = progressBar.getMax();
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 0:
                        progressBar.setProgress(currentProgress);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Thread(){
            @Override
            public void run() {
                try {
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(1000);
                        currentProgress += 10;
                        if (currentProgress > maxProgress) {
                            break;
                        }
                        mHandler.sendEmptyMessage(0);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
