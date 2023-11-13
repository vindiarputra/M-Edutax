package com.example.tc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PptKewarganegaraan extends AppCompatActivity implements View.OnClickListener {
    public Button Mg1, Mg2, Mg3, Mg4, Mg5, Mg6, Mg7, Mg8, Mg9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ppt_kewarganegaraan);

        Mg1 = (Button) findViewById(R.id.button1);
        Mg2 = (Button) findViewById(R.id.button2);
        Mg3 = (Button) findViewById(R.id.button3);
        Mg4 = (Button) findViewById(R.id.button4);
        Mg5 = (Button) findViewById(R.id.button5);
        Mg6 = (Button) findViewById(R.id.button6);
        Mg7 = (Button) findViewById(R.id.button7);
        Mg8 = (Button) findViewById(R.id.button8);
        Mg9 = (Button) findViewById(R.id.button9);

        Mg1.setOnClickListener(this);
        Mg2.setOnClickListener(this);
        Mg3.setOnClickListener(this);
        Mg4.setOnClickListener(this);
        Mg5.setOnClickListener(this);
        Mg6.setOnClickListener(this);
        Mg7.setOnClickListener(this);
        Mg8.setOnClickListener(this);
        Mg9.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/presentation/d/1mOSLckC4dyQDG-AP7uBkJ8SoKX_jrUUb/edit?usp=sharing&ouid=106405570099632073721&rtpof=true&sd=true"));
                startActivity(browserIntent);
                break;
            case R.id.button2:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/presentation/d/1Njzg1ISusHWTRk-eFI4c_qB0A9tGiU9k/edit?usp=sharing&ouid=106405570099632073721&rtpof=true&sd=true"));
                startActivity(browserIntent);
                break;
            case R.id.button3:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/presentation/d/1JOtLIqO2paP4mUMZXBecUBT1h7yGUgk7/edit?usp=sharing&ouid=106405570099632073721&rtpof=true&sd=true"));
                startActivity(browserIntent);
                break;
            case R.id.button4:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/presentation/d/1f8tTvWmLvPl8TYJcoVurHkD_5D83z7Kn/edit?usp=sharing&ouid=106405570099632073721&rtpof=true&sd=true"));
                startActivity(browserIntent);
                break;
            case R.id.button5:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/presentation/d/1XlFelhL0WNPqJLtmwbBgN4zyBpSbSfCf/edit?usp=sharing&ouid=106405570099632073721&rtpof=true&sd=true"));
                startActivity(browserIntent);
                break;
            case R.id.button6:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/presentation/d/1lEYr5kCAuaGz3P3YVY44gS-1bNB8CGf-/edit?usp=sharing&ouid=106405570099632073721&rtpof=true&sd=true"));
                startActivity(browserIntent);
                break;
            case R.id.button7:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/presentation/d/1FtJoM0_tmDkWZaLh87XP9-L4ppRyTvEG/edit?usp=sharing&ouid=106405570099632073721&rtpof=true&sd=true"));
                startActivity(browserIntent);
                break;
            case R.id.button8:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/presentation/d/1-kMp84qzSb9aDFlRqDSz1ZHhNmXxLGsG/edit?usp=sharing&ouid=106405570099632073721&rtpof=true&sd=true"));
                startActivity(browserIntent);
                break;
            case R.id.button9:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(" https://docs.google.com/presentation/d/1qRYq9cwje_Zw0-eVybewkitzyJtMrFKv/edit?usp=sharing&ouid=106405570099632073721&rtpof=true&sd=true"));
                startActivity(browserIntent);
                break;

        }
    }
}