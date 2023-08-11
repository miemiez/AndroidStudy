package com.example.myapplicationdemo02;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

public class ChronometerActivity extends ComponentActivity implements View.OnClickListener, Chronometer.OnChronometerTickListener {
    private Chronometer chronometer;
    private Button btn_start,btn_stop,btn_base,btn_format;
    private static final String TAG = "MyApp"; // 示例的标签

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chronometer_layout);
        initView();
    }

    private void initView(){
        chronometer = findViewById(R.id.chronometer);
        btn_start = findViewById(R.id.btnStart); // 为按钮变量初始化
        btn_stop = findViewById(R.id.btnStop);
        btn_base = findViewById(R.id.btnReset);
        btn_format = findViewById(R.id.btn_format);

        chronometer.setOnChronometerTickListener(this);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_base.setOnClickListener(this);
        btn_format.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        int i = view.getId();
        if(i == R.id.btnStart){
            chronometer.start();
        }else if(i == R.id.btnStop){
            chronometer.stop();
        }else if(i == R.id.btnReset){
            chronometer.setBase(SystemClock.elapsedRealtime());//复位
        }else if(i == R.id.btn_format) {
            chronometer.setFormat("Time: %s");
        }
    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {
        String time = chronometer.getText().toString();
        Log.i(TAG,time);
    }
}
