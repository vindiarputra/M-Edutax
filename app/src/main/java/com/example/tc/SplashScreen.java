package com.example.tc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Activity;


public class SplashScreen extends AppCompatActivity {

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Thread timer=new Thread()
        {
            @Override            public void run() {
                try                {
                    music=MediaPlayer.create(SplashScreen.this,R.raw.introedutax);
                    music.start();
                    sleep(16000);

                }
                catch(InterruptedException e)
                {

                }
                finally {
                    Intent i=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(i);
                }
            }
        };

        timer.start();

        int SPLASH_SCREEN_TIME = 16000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(intent);
                SplashScreen.this.finish();

            }
        },SPLASH_SCREEN_TIME);
    }

    @Override    protected void onPause() {
        super.onPause();
        music.release();
    }
}