package com.creativeitinstitute.quizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class SplashActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        countDownTimer = new CountDownTimer(3000, 100) {
            @Override
            public void onTick(final long l) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this, DashBoardActivity.class);
                startActivity(intent);
                finish();

            }
        }.start();


    }
}