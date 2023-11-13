package com.example.tc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ActivityInklusi extends AppCompatActivity implements View.OnClickListener {

    public Button Bindo, Pancasila, Kewarganegaraan, Agama;
    public CardView Islam, Kristen, Khatolik, Budha, Hindu, Close;
    public RelativeLayout cvInklusi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inklusi);

        /*main button*/

        Bindo = (Button) findViewById(R.id.button1);
        Pancasila = (Button) findViewById(R.id.button2);
        Kewarganegaraan = (Button) findViewById(R.id.button3);
        Agama = (Button) findViewById(R.id.button4);
        Close = (CardView) findViewById(R.id.close);

        Islam = (CardView) findViewById(R.id.islam);
        Kristen = (CardView) findViewById(R.id.kristen);
        Khatolik = (CardView) findViewById(R.id.khatolik);
        Hindu = (CardView) findViewById(R.id.hindu);
        Budha = (CardView) findViewById(R.id.budha);

        cvInklusi = (RelativeLayout) findViewById(R.id.cvagama);

        Bindo.setOnClickListener(this);
        Pancasila.setOnClickListener(this);
        Kewarganegaraan.setOnClickListener(this);
        Agama.setOnClickListener(this);
        Close.setOnClickListener(this);

        Islam.setOnClickListener(this);
        Kristen.setOnClickListener(this);
        Khatolik.setOnClickListener(this);
        Hindu.setOnClickListener(this);
        Budha.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
                case R.id.button1:
                    i = new Intent(this, InklusiBahasaindonesia.class);
                    startActivity(i);
                    break;
            case R.id.button2:
                i = new Intent(this, InklusiPancasila.class);
                startActivity(i);
                break;
            case R.id.button3:
                i = new Intent(this, InklusiKewarganegaraan.class);
                startActivity(i);
                break;
            case R.id.button4:
                cvInklusi.setVisibility(View.VISIBLE);
                break;
            case R.id.close:
                cvInklusi.setVisibility(View.INVISIBLE);
                break;
            case R.id.islam:
                i = new Intent(this, InklusiIslam.class);
                startActivity(i);
                break;
            case R.id.khatolik:
                i = new Intent(this, InklusiKhatolik.class);
                startActivity(i);
                break;
            case R.id.kristen:
                i = new Intent(this, InklusiKristen.class);
                startActivity(i);
                break;
            case R.id.hindu:
                i = new Intent(this, InklusiHindu.class);
                startActivity(i);
                break;
            case R.id.budha:
                i = new Intent(this, InklusiBudha.class);
                startActivity(i);
                break;
   
        }
    }
}






        /*Bindo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ActivityInklusi.this, InklusiBahasaindonesia.class);
                startActivity(i);
                finish();
            }
        });

        Pancasila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ActivityInklusi.this, InklusiPancasila.class);
                startActivity(i);
                finish();

            }
        });

        Kewarganegaraan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ActivityInklusi.this, InklusiKewarganegaraan.class);
                startActivity(i);
                finish();

            }
        });

        Agama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cvInklusi.setVisibility(View.VISIBLE);

            }
        });

        Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cvInklusi.setVisibility(View.INVISIBLE);

            }
        });

        Islam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ActivityInklusi.this, InklusiIslam.class);
                startActivity(i);
                finish();

            }
        });
        Kristen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ActivityInklusi.this, InklusiKristen.class);
                startActivity(i);
                finish();

            }
        });
        Khatolik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ActivityInklusi.this, InklusiKhatolik.class);
                startActivity(i);
                finish();

            }
        });
        Hindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ActivityInklusi.this, InklusiHindu.class);
                startActivity(i);
                finish();

            }
        });
        Budha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ActivityInklusi.this, InklusiBudha.class);
                startActivity(i);
                finish();

            }
        });
    }
*/
