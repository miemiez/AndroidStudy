package com.example.myapplicationdemo02;

import android.content.Context;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

public class SeekBarActivity extends ComponentActivity {
    private SeekBar sb_normal, sb_custom;
    private TextView txt_cur;
    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar_layout);
        mContext = this;
        sb_normal = findViewById(R.id.sb_normal);
        sb_custom = findViewById(R.id.sb_custom);
        txt_cur = findViewById(R.id.txt_cur);
        sb_normal.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txt_cur.setText("当前进度值：" + progress + " / 100");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(mContext,"触碰SeekBar",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(mContext,"放开SeekBar",Toast.LENGTH_SHORT).show();
            }
        });
        sb_custom.setSecondaryProgress(60);
    }
}
