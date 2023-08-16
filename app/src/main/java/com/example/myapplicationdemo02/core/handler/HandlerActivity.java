package com.example.myapplicationdemo02.core.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationdemo02.R;

import java.util.Timer;
import java.util.TimerTask;

public class HandlerActivity extends AppCompatActivity{
    private int num = 0;
    private TextView tv;

    private Timer timer= new Timer();

    private Handler myHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 0){
                num++;
                tv.setText(String.valueOf(num));
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_layout);
        Button getButton = findViewById(R.id.btn_send);
        tv = findViewById(R.id.tv_content);
        getButton.setOnClickListener(view -> {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    myHandler.sendEmptyMessage(0);
                }
            }, 0, 1000);;
        });
    }
}
