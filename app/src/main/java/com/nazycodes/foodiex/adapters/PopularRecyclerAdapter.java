package com.nazycodes.foodiex.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nazycodes.foodiex.R;
import com.nazycodes.foodiex.models.Food;
import com.nazycodes.foodiex.screens.FoodDetailsScreen;

import java.util.List;

public class PopularRecyclerAdapter extends RecyclerView.Adapter<PopularRecyclerAdapter.ViewHolder> {

    private final Context context;
    private final List<Food> foods;
    private final LayoutInflater layoutInflater;

    public PopularRecyclerAdapter(Context context, List<Food> foods) {
        this.context = context;
        this.foods = foods;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = layoutInflater.inflate(R.layout.popular_list, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Food food = foods.get(i);
        viewHolder.title.setText(food.getTitle());
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView title;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FoodDetailsScreen.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}

