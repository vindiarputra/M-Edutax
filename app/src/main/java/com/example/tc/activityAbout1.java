package com.example.tc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;

import java.io.File;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import java.util.ArrayList;
import androidx.cardview.widget.CardView;


public class activityAbout1 extends AppCompatActivity implements View.OnClickListener {

    public CardView first, second, third, fourth, fifth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageSlider imageSlider;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about1);

        first = (CardView) findViewById(R.id.button1);
        second = (CardView) findViewById(R.id.button2);
        third = (CardView) findViewById(R.id.button3);
        fourth = (CardView) findViewById(R.id.button4);
        fifth = (CardView) findViewById(R.id.button5);



        first.setOnClickListener(this);
        second.setOnClickListener(this);
        third.setOnClickListener(this);
        fourth.setOnClickListener(this);
        fifth.setOnClickListener(this);

        imageSlider = findViewById(R.id.slider);

        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(R.drawable.slide1, null));
        images.add(new SlideModel(R.drawable.slide2, null));
        images.add(new SlideModel(R.drawable.slide3, null));
        images.add(new SlideModel(R.drawable.slide4, null));
        images.add(new SlideModel(R.drawable.slide5, null));
        images.add(new SlideModel(R.drawable.slide6, null));
        images.add(new SlideModel(R.drawable.slide7, null));
        images.add(new SlideModel(R.drawable.slide8, null));
        images.add(new SlideModel(R.drawable.slide9, null));
        images.add(new SlideModel(R.drawable.slide10, null));

        imageSlider.setImageList(images, ScaleTypes.CENTER_CROP);
        imageSlider.startSliding(2000);
    }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.button1:
                i = new Intent(this, firstAbout.class);
                startActivity(i);
                break;
            case R.id.button2:
                i = new Intent(this, secondAbout.class);
                startActivity(i);
                break;
            case R.id.button3:
                i = new Intent(this, thirdAbout.class);
                startActivity(i);
                break;
            case R.id.button4:
                i = new Intent(this, fourthAbout.class);
                startActivity(i);
                break;
            case R.id.button5:
                i = new Intent(this, fifthAbout.class);
                startActivity(i);
                break;
        }
    }
}