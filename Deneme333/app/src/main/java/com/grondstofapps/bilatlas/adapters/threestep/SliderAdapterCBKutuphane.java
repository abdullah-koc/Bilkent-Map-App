package com.grondstofapps.bilatlas.adapters.threestep;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.grondstofapps.bilatlas.R;

public class SliderAdapterCBKutuphane extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapterCBKutuphane(Context context){
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three
    };

    public String[] texts = {
            "Zemin kattaki Coffee Break, kütüphane girişindedir. Üst kattaki Coffee Break için: Kütüphane girişinden 1 kat yukarı çıkın.",
            "Kütüphanenin A bloğu ile B bloğu arasındaki köprüyü kullanarak B bloğuna geçin.",
            "Merdivenler ile 2 kat yukarı çıkın. Coffee Break karşınızdadır."
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