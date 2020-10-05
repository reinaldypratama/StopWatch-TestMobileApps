package com.example.stopwatch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseSet;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
    }

    

    public void startChronometer(View view){
        if(!running){ //ketika dia gak jalan
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseSet); //set waktunya dikurang pause set
            chronometer.start(); // jalankan
            running = true; //runingny jadi true

        }
    }
    public void pauseChronometer(View view){
        if(running){
            chronometer.stop(); //cronometernya stop
            pauseSet = SystemClock.elapsedRealtime() - chronometer.getBase(); //pauseset itu waktu di set waktu sekarang di kurang waktu awal(base)
            running = false;
        }
    }
    public void resetChronometer(View view){
        chronometer.setBase(SystemClock.elapsedRealtime()); // set waktunya
        pauseSet = 0; //pause setny 0

    }
}