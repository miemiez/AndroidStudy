package com.example.myapplicationdemo02;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;

import com.example.myapplicationdemo02.R;


public class ProgressBarActivity03 extends ComponentActivity {
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prograssbar_layout);

        progressBar = findViewById(R.id.pb);

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                if (msg.what == 0) {
                    if (progressStatus < 100) {
                        progressStatus+=10;
                        progressBar.setProgress(progressStatus);
                        handler.sendEmptyMessageDelayed(0, 1000);
                    }
                }
                return true;
            }
        });

        handler.sendEmptyMessage(0);
    }
}