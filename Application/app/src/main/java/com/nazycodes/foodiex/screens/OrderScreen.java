package com.nazycodes.foodiex.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.nazycodes.foodiex.R;
import com.nazycodes.foodiex.adapters.IngredientsRecyclerAdapter;
import com.nazycodes.foodiex.adapters.OrderViewPagerAdapter;

import java.util.ArrayList;

public class OrderScreen extends AppCompatActivity {

    private ViewPager mViewPager;
    private OrderViewPagerAdapter mViewPagerAdapter;
    private TabLayout mTabLayout;
    private RelativeLayout backArrow;
    private TextView heading;
    private String foodTitle;
    private ArrayList<String> ingredients;
    private RecyclerView recyclerView;
    private IngredientsRecyclerAdapter ingredientsRecyclerAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);

        foodTitle = getIntent().getStringExtra("title");

        backArrow = findViewById(R.id.back_arrow);
        heading = findViewById(R.id.fragment_heading);
        recyclerView = findViewById(R.id.people_lists);

        heading.setText(foodTitle);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        setViewPager();
        init();
    }

    public void setViewPager(){
        mViewPager = findViewById(R.id.pager);
        mViewPagerAdapter = new OrderViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);

        mTabLayout = findViewById(R.id.tab);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    public void init(){
        ingredients = new ArrayList<>();
        ingredients.add("salt");
        ingredients.add("pepper");
        ingredients.add("onions");
        ingredients.add("crayfish");

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ingredientsRecyclerAdapter = new IngredientsRecyclerAdapter(this, ingredients);
        recyclerView.setAdapter(ingredientsRecyclerAdapter);
    }
}
