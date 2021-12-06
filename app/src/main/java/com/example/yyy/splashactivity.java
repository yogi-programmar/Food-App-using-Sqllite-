package com.example.yyy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class splashactivity extends AppCompatActivity {
    private long ms = 0;
    private long splashTime = 1000;
    private boolean splashActives = true;
    private boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread mythread = new Thread() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void run() {
                try {
                    while (splashActives && ms < splashTime) {
                        if (!paused)
                            ms = ms + 100;
                        sleep(100);
                    }
                } catch (Exception e) {
                } finally {
                    Intent intent = new Intent(splashactivity.this, orderactivity.class);

                    startActivity(intent);
                    finish();


                }
            }


        };

        mythread.start();

    }
}