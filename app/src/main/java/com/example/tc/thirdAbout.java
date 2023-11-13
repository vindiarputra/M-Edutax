package com.example.tc;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.media.AudioManager;

import android.os.Bundle;

public class thirdAbout extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_about);

        mp = MediaPlayer.create(this, R.raw.kenapaadapajak);
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp.setLooping(false);
        mp.start();
    }
    @Override  protected void onPause() {
        super.onPause();
        mp.release();
    }
}