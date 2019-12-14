package com.nazycodes.foodiex.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nazycodes.foodiex.R;
import com.nazycodes.foodiex.models.Food;
import com.nazycodes.foodiex.screens.FoodDetailsScreen;

import java.util.List;

public class IngredientsRecyclerAdapter extends RecyclerView.Adapter<IngredientsRecyclerAdapter.ViewHolder> {

    private final Context context;
    private final List<String> ingredients;
    private final LayoutInflater layoutInflater;

    public IngredientsRecyclerAdapter(Context context, List<String> ingredients) {
        this.context = context;
        this.ingredients = ingredients;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = layoutInflater.inflate(R.layout.ingredients_list, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String ingredient = ingredients.get(i);
        viewHolder.ingredient.setText(ingredient);
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final CheckBox ingredient;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            ingredient = itemView.findViewById(R.id.ingredient_checkbox);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}

