package com.nazycodes.foodiex.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.nazycodes.foodiex.R;
import com.nazycodes.foodiex.adapters.FoodViewPagerAdapter;

public class FoodDetailsScreen extends AppCompatActivity {

    private ViewPager mViewPager;
    private FoodViewPagerAdapter mViewPagerAdapter;
    private TabLayout mTabLayout;
    private MaterialButton btnOrder;
    private RelativeLayout backArrow;
    private TextView heading;
    private String foodTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details_screen);

        foodTitle = getIntent().getStringExtra("title");

        btnOrder = findViewById(R.id.btnOrder);
        backArrow = findViewById(R.id.back_arrow);
        heading = findViewById(R.id.fragment_heading);

        setViewPager();

        heading.setText(foodTitle);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodDetailsScreen.this, OrderScreen.class);
                intent.putExtra("title", foodTitle);
                startActivity(intent);
            }
        });

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void setViewPager(){
        mViewPager = findViewById(R.id.pager);
        mViewPagerAdapter = new FoodViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);

        mTabLayout = findViewById(R.id.tab);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
