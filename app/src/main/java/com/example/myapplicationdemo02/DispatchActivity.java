package com.example.myapplicationdemo02;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

public class DispatchActivity extends ComponentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dispatch_layout);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("ttit", "DispatchActivity ://////dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("ttit", "DispatchActivity ://////onTouchEvent event ="+event.getAction());
        return false;
    }
}
