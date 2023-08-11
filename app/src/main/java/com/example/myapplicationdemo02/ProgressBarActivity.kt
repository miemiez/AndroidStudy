package com.example.myapplicationdemo02

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import androidx.activity.ComponentActivity

class ProgressBarActivity : ComponentActivity() {
    private var currentProgress:Int = 0
    private lateinit var mHandler: Handler
    private lateinit var progressBar:ProgressBar
    private lateinit var maxProgress:Any
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.prograssbar_layout)
        progressBar = findViewById(R.id.pb);
        maxProgress = progressBar.max
        mHandler = Handler(Looper.getMainLooper()){
            when(it.what){
                0 -> {
                    progressBar.setProgress(currentProgress)
                    true
                }
                else -> false
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Thread{
            while(true) (
                try {
                    for(i:Int in 0..100 ){
                        Thread.sleep(1000)
                        currentProgress += 10
                        if(currentProgress > maxProgress as Int){
                            break
                        }
                        mHandler.sendEmptyMessage(0)
                    }
                } catch (e:InterruptedException){
                    e.printStackTrace()
                }
            )
        }.start()
    }
}