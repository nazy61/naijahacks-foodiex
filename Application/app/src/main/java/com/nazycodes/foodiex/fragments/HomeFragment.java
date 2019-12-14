package com.nazycodes.foodiex.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nazycodes.foodiex.R;
import com.nazycodes.foodiex.adapters.CategoryRecyclerAdapter;
import com.nazycodes.foodiex.adapters.PopularRecyclerAdapter;
import com.nazycodes.foodiex.models.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment {

    private ArrayList<Food> foods;
    private CategoryRecyclerAdapter foodRecyclerAdapter;
    private PopularRecyclerAdapter popularRecyclerAdapter;
    private RecyclerView categoryRecyclerView;
    private RecyclerView popularRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private ViewFlipper imageSlider;
    private ArrayList<Integer> images;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.home_fragment, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        imageSlider = view.findViewById(R.id.image_slider);
        categoryRecyclerView = view.findViewById(R.id.food_lists);
        popularRecyclerView = view.findViewById(R.id.popular_lists);
        init();
        for(int image: images){
            slideImages(image);
        }
    }

    public void init(){
        images = new ArrayList<>();
        foods = new ArrayList<>();
        List<String> test = new ArrayList<>();
        List<Map<String, Object>> ingredients = new ArrayList<>();
        images.add(R.drawable.b);
        images.add(R.drawable.i);
        images.add(R.drawable.y);

        foods.add(new Food("1", "Cake", ingredients, 34, "", 36, test, "", "", ingredients, false));
        foods.add(new Food("1", "Indomie", ingredients, 34, "", 36, test, "", "", ingredients, false));
        foods.add(new Food("1", "Tea", ingredients, 34, "", 36, test, "", "", ingredients, false));
        foods.add(new Food("1", "Soup", ingredients, 34, "", 36, test, "", "", ingredients, false));
        foods.add(new Food("1", "Rice", ingredients, 34, "", 36, test, "", "", ingredients, false));
        foods.add(new Food("1", "Fish", ingredients, 34, "", 36, test, "", "", ingredients, false));
        foods.add(new Food("1", "Yam", ingredients, 34, "", 36, test, "", "", ingredients, false));

        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        categoryRecyclerView.setLayoutManager(linearLayoutManager);
        popularRecyclerView.setLayoutManager(gridLayoutManager);

        foodRecyclerAdapter = new CategoryRecyclerAdapter(getActivity(), foods);
        popularRecyclerAdapter = new PopularRecyclerAdapter(getActivity(), foods);
        categoryRecyclerView.setAdapter(foodRecyclerAdapter);
        popularRecyclerView.setAdapter(popularRecyclerAdapter);
    }

    public void slideImages(int image){
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);

        imageSlider.addView(imageView);
        imageSlider.setFlipInterval(5000);
        imageSlider.setAutoStart(true);

        //animation
        imageSlider.setInAnimation(getActivity(), R.anim.slide_in_right);
        imageSlider.setOutAnimation(getActivity(), R.anim.slide_out_left);
    }
}
