package com.example.toyin.foodfly.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.toyin.foodfly.R;

/**
 * Created by Toyin on 23/06/2017.
 */

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main = new Intent(SplashScreen.this, Login.class);
                startActivity(main);
                finish();
            }
        },SPLASH_SCREEN_TIME_OUT);
    }
}
