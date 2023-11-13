package com.example.tc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class InklusiHindu extends AppCompatActivity implements View.OnClickListener {
    public Button SAP, Materi, Video, Penugasan;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageSlider imageSlider;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inklusi_hindu);

        SAP = (Button) findViewById(R.id.button1);
        Materi = (Button) findViewById(R.id.button2);
        Video = (Button) findViewById(R.id.button3);
        Penugasan = (Button) findViewById(R.id.button4);


        SAP.setOnClickListener(this);
        Materi.setOnClickListener(this);
        Video.setOnClickListener(this);
        Penugasan.setOnClickListener(this);
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


    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.button1:
                i = new Intent(this, SapHindu.class);
                startActivity(i);
                break;

            case R.id.button2:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/1Rlz_oj096SEV7jdgtXhniwbxRgrR9D-2/view?usp=sharing"));
                startActivity(browserIntent);
                break;

            case R.id.button3:
                i = new Intent(this, VideoHindu.class);
                startActivity(i);
                break;

            case R.id.button4:
                i = new Intent(this, PenugasanHindu.class);
                startActivity(i);
                break;
        }
    }
}