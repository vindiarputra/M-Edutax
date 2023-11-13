package com.example.tc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView About, Inklusi, Komik, Games;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageSlider imageSlider;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        About = (CardView) findViewById(R.id.about);
        Inklusi = (CardView) findViewById(R.id.inklusi);
        Komik = (CardView) findViewById(R.id.komik);
        Games = (CardView) findViewById(R.id.games);

        About.setOnClickListener(this);
        Inklusi.setOnClickListener(this);
        Komik.setOnClickListener(this);
        Games.setOnClickListener(this);

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
            case R.id.about:
                i = new Intent(this, activityAbout1.class);
                startActivity(i);
                break;
            case R.id.inklusi:
                i = new Intent(this, ActivityInklusi.class);
                startActivity(i);
                break;
            case R.id.komik:
                i = new Intent(this, ActivityKomik.class);
                startActivity(i);
                break;
            case R.id.games:
                i = new Intent(this, ActivityGame.class);
                startActivity(i);
                break;
        }
    }
}