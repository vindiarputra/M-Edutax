package com.example.tc;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ActivityAbout extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout dotsLayout;
    Button homeBtn, backBtn, nextBtn;
    MediaPlayer music;

    SliderAdapter sliderAdapter;
    TextView[] dots;

    private int currentPos = 0;
    private int prevPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //HOOKS
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots_dots);
        homeBtn = findViewById(R.id.home);
        backBtn = findViewById(R.id.btn_back);
        nextBtn = findViewById(R.id.btn_next);


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityAbout.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getitem(0) > 0) {
                    viewPager.setCurrentItem(getitem(-1), true);
                }

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getitem(0) < 4) {
                    viewPager.setCurrentItem(getitem(1), true);

                } else {
                    Intent i = new Intent(ActivityAbout.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });

        viewPager = (ViewPager) findViewById(R.id.slider);
        dotsLayout = (LinearLayout) findViewById(R.id.dots_dots);

        //ADAPTER
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(viewListener);
    }

    private void addDots(int position) {
        dots = new TextView[5];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive, getApplicationContext().getTheme()));
            dotsLayout.addView(dots[i]);
        }

        //. dots[position].setTextColor(getResources().getColor(R.color.active, getApplicationContext().getTheme()));


        //*additional
        if(dots.length>0) {
            dots[position].setTextColor(getResources().getColor(R.color.active, getApplicationContext().getTheme()));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDots(position);

            if (position == 0) {
                nextBtn.setEnabled(true);
                backBtn.setEnabled(false);
                backBtn.setVisibility(View.INVISIBLE);
                homeBtn.setVisibility(View.VISIBLE);

                nextBtn.setText(R.string.next);
                backBtn.setText("");
            } else if (position == dots.length -1) {
                nextBtn.setEnabled(true);
                backBtn.setEnabled(true);
                backBtn.setVisibility(View.VISIBLE);
                homeBtn.setVisibility(View.INVISIBLE);

                nextBtn.setText(R.string.finish);
                backBtn.setText(R.string.back);
            } else {
                nextBtn.setEnabled(true);
                backBtn.setEnabled(true);
                backBtn.setVisibility(View.VISIBLE);
                homeBtn.setVisibility(View.INVISIBLE);

                nextBtn.setText(R.string.next);
                backBtn.setText(R.string.back);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getitem(int i) {
        return viewPager.getCurrentItem() + i;
    }
}