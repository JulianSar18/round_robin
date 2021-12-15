package com.roundrobin.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Activity_teoria extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;
    protected Button inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teoria);
        inicio=(Button)findViewById(R.id.btn_inicio);
        inicio.setOnClickListener((
                View v)->{
            Intent intent= new Intent(v.getContext(),MainActivity.class);
            startActivity(intent);
        });
        setupOnboardingItems();
        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);
    }

    private void setupOnboardingItems(){
        List<Onboardingitem> onboardingItems = new ArrayList<>();

        Onboardingitem itemPayOnline = new Onboardingitem();
        itemPayOnline.setTitle(getString(R.string.titulo1));
        itemPayOnline.setDescription(getString(R.string.definicion));
        itemPayOnline.setImage(R.drawable.img1);

        Onboardingitem itemOntheway = new Onboardingitem();
        itemOntheway.setTitle(getString(R.string.titulo2));
        itemOntheway.setDescription(getString(R.string.apli_so));
        itemOntheway.setImage(R.drawable.img2);

        Onboardingitem item = new Onboardingitem();
        item.setTitle(getString(R.string.titulo3));
        item.setDescription(getString(R.string.Formula));
        item.setImage(R.drawable.img3);

        onboardingItems.add(itemPayOnline);
        onboardingItems.add(itemOntheway);
        onboardingItems.add(item);


        onboardingAdapter = new OnboardingAdapter(onboardingItems);

    }

}