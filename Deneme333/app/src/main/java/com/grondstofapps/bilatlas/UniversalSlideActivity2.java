package com.grondstofapps.bilatlas;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.grondstofapps.bilatlas.adapters.twostep.*;

public class UniversalSlideActivity2 extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private PagerAdapter sliderAdapter;

    private TextView[] dots;

    private Button buttonBack, buttonForward;

    private int currentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universal_slider2);

        buttonBack = findViewById(R.id.buttonBack);
        buttonForward = findViewById(R.id.buttonForward);

        viewPager = findViewById(R.id.viewPager);
        linearLayout = findViewById(R.id.linearLayout);

        String buildingMap = getIntent().getStringExtra("building");

        if(buildingMap.equals("Lab")){ sliderAdapter = new SliderAdapterLab(this); }
        if(buildingMap.equals("CBlokAmfi")){ sliderAdapter = new SliderAdapterCBlokAmfi(this); }
        if(buildingMap.equals("FieroG")){ sliderAdapter = new SliderAdapterFieroG(this); }
        if(buildingMap.equals("MozartB")){ sliderAdapter = new SliderAdapterMozartB(this); }
        if(buildingMap.equals("MozartD")){ sliderAdapter = new SliderAdapterMozartD(this); }
        if(buildingMap.equals("MozartEE")){ sliderAdapter = new SliderAdapterMozartEE(this); }
        if(buildingMap.equals("MozartN")){ sliderAdapter = new SliderAdapterMozartN(this); }
        if(buildingMap.equals("StarbucksA")){ sliderAdapter = new SliderAdapterStarbucksA(this); }
        if(buildingMap.equals("StarbucksFC")){ sliderAdapter = new SliderAdapterStarbucksFC(this); }
        if(buildingMap.equals("FameoEA")){ sliderAdapter = new SliderAdapterFameoEA(this);}
        if(buildingMap.equals("Rektorluk")){ sliderAdapter = new SliderAdapterRektorluk(this);}



        viewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(currentPage - 1);
            }
        });

        buttonForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPage != dots.length - 1){
                    viewPager.setCurrentItem(currentPage +1);
                }
                if(currentPage == dots.length - 1){
                    startActivity(new Intent(getApplicationContext(), SuccessfullyArrivedActivity.class));
                    finish();
                }

            }
        });
    }

    public void addDotsIndicator(int position){

        dots = new TextView[2];
        linearLayout.removeAllViews();

        for(int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            dots[i].setTextSize(40);

            linearLayout.addView(dots[i]);
        }

        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);

            currentPage = position;
            if(position == 0){
                buttonBack.setEnabled(false);
                buttonBack.setVisibility(View.INVISIBLE);
                buttonForward.setBackground(getDrawable(R.drawable.ic_arrow_forward_black_24dp));
            }
            else{
                buttonForward.setEnabled(true);
                buttonBack.setEnabled(true);
                buttonBack.setVisibility(View.VISIBLE);
                buttonForward.setBackground(getDrawable(R.drawable.ic_check_black_24dp));
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}