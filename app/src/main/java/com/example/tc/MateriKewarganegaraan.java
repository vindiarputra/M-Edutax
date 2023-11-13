package com.example.tc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MateriKewarganegaraan extends AppCompatActivity implements View.OnClickListener {
    public Button Materi, PPT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_kewarganegaraan);


        Materi = (Button) findViewById(R.id.button1);
        PPT = (Button) findViewById(R.id.button2);


        Materi.setOnClickListener(this);
        PPT.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.button1:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/130yFVhPtXES-FEtikLsVIl0csVsGdzA1/view?usp=sharing"));
                startActivity(browserIntent);
                break;

            case R.id.button2:
                i = new Intent(this, PptKewarganegaraan.class);
                startActivity(i);
                break;

        }

    }
}