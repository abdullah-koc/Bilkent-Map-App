package com.example.deneme333.adapters.twostep;

import android.content.Context;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.deneme333.R;

public class SliderAdapterFameoEA extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapterFameoEA( Context context){
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.one,
            R.drawable.two
    };

    public String[] texts = {
            "Ea binası girişinden dümdüz ilerleyin.",
            "Fameo cafe sağ taraftadır."
    };

    @Override
    public int getCount() {
        return texts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.lab_slide_layout, container, false);

        ImageView image = view.findViewById(R.id.image);
        TextView textView = view.findViewById(R.id.textView);

        image.setImageResource(slide_images[position]);
        textView.setText(texts[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}