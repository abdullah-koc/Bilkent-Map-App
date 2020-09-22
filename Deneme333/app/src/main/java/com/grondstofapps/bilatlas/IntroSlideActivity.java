package com.grondstofapps.bilatlas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.mapbox.android.core.permissions.PermissionsManager;

public class IntroSlideActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private PagerAdapter sliderAdapter;

    private TextView[] dots;


    private Button buttonBack, buttonForward;

    private int currentPage;

    private PermissionsManager permissionsManager;

    private static final int PERMISSION_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_slide);


        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            buttonBack = findViewById(R.id.buttonBackIntro);
            buttonForward = findViewById(R.id.buttonForwardIntro);

            viewPager = findViewById(R.id.viewPager);
            linearLayout = findViewById(R.id.linearLayout);

            SliderAdapterIntro sliderAdapterIntro = new SliderAdapterIntro(this);




            viewPager.setAdapter(sliderAdapterIntro);

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
                        if(ContextCompat.checkSelfPermission(getApplicationContext(),
                                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED){
                            requestLocationPermission();
                        }

                    }
                    if(currentPage == dots.length - 1){
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }

                }
            });
        }
        else{
            startActivity( new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();


    }

    public void requestLocationPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
        }
        else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == PERMISSION_CODE){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                viewPager.setCurrentItem(currentPage + 1);
            }
        }
    }

    public void addDotsIndicator(int position){

        dots = new TextView[3];
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
                buttonForward.setEnabled(true);
                buttonBack.setEnabled(false);
                buttonBack.setVisibility(View.INVISIBLE);
            }
            else if(position== dots.length-1){
                buttonForward.setEnabled(true);
                buttonBack.setEnabled(true);
                buttonBack.setVisibility(View.VISIBLE);

                buttonForward.setBackground(getDrawable(R.drawable.ic_check_black_24dp));
            }
            else{
                buttonForward.setEnabled(true);
                buttonBack.setEnabled(true);
                buttonForward.setBackground(getDrawable(R.drawable.ic_arrow_forward_black_24dp));
                requestLocationPermission();
                buttonBack.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}