package com.example.finalarisan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep( 1000);
                } catch (Exception ex){
                    ex.printStackTrace();
                }finally {
                    Intent intentMain = new Intent
                            (SplashScreenActivity.this,MainActivity.class);
                    startActivity (intentMain);
                }
            }
        };
        timer.start();
    }
}