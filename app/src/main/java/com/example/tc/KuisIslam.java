package com.example.tc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class KuisIslam extends AppCompatActivity implements View.OnClickListener {
    public Button Easy, Medium, Hard;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageSlider imageSlider;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kuis_islam);

        Easy = (Button) findViewById(R.id.button1);
        Medium = (Button) findViewById(R.id.button2);
        Hard = (Button) findViewById(R.id.button3);

        Easy.setOnClickListener(this);
        Medium.setOnClickListener(this);
        Hard.setOnClickListener(this);

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
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.button1:
                i = new Intent(this, KuisIslamEasy.class);
                startActivity(i);
                break;
            case R.id.button2:
                i = new Intent(this, KuisIslamMedium.class);
                startActivity(i);
                break;
            case R.id.button3:
                i = new Intent(this, KuisIslamHard.class);
                startActivity(i);
                break;

        }

    }
}
