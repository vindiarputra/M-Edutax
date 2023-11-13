package com.example.tc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tc.R;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class ActivityGame extends AppCompatActivity implements View.OnClickListener {

    public Button Easy, Medium, Hard;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageSlider imageSlider;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

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
                i = new Intent(this, ActivityGameEasy.class);
                startActivity(i);
                break;
            case R.id.button2:
                i = new Intent(this, ActivityGameMedium.class);
                startActivity(i);
                break;
            case R.id.button3:
                i = new Intent(this, ActivityGameHard.class);
                startActivity(i);
                break;

        }

    }
}