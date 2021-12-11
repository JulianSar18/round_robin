package com.roundrobin.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Activity_teoria extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teoria);

        setupOnboardingItems();
        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);
    }

    private void setupOnboardingItems(){
        List<Onboardingitem> onboardingItems = new ArrayList<>();

        Onboardingitem itemPayOnline = new Onboardingitem();
        itemPayOnline.setTitle("pay online");
        itemPayOnline.setDescription("electrodemiestico");
        itemPayOnline.setImage(R.drawable.img1);

        Onboardingitem itemOntheway = new Onboardingitem();
        itemOntheway.setTitle("pay online");
        itemOntheway.setDescription("oli");
        itemOntheway.setImage(R.drawable.img2);

        Onboardingitem item = new Onboardingitem();
        item.setTitle("pay online");
        item.setDescription("oli2");
        item.setImage(R.drawable.img2);

        onboardingItems.add(itemPayOnline);
        onboardingItems.add(itemOntheway);
        onboardingItems.add(item);


        onboardingAdapter = new OnboardingAdapter(onboardingItems);

    }
}