package com.grondstofapps.bilatlas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.grondstofapps.bilatlas.R;

public class SliderAdapterIntro extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapterIntro(Context context){
        this.context = context;
    }

    public String[] texts = {
            "BilAtlas'a hoşgeldin Bilkentli! Bu uygulama sayesinde kampüste bilmediğin her yeri öğrenebileceksin! Ama önce konumuna erişmemize izin vermen gerekiyor.",
            "Lütfen konum erişimine izin ver.",
            "Harika! Artık BilAtlas'ı kullanmaya hazırsın. Uygulamayı kullanırken geçerli bir internet bağlantısına sahip olmayı unutma!"
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
        View view = layoutInflater.inflate(R.layout.intro_slide_layout, container, false);

        TextView textView = view.findViewById(R.id.textView);

        textView.setText(texts[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}