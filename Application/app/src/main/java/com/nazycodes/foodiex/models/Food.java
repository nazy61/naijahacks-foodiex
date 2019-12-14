package com.nazycodes.foodiex.models;

import java.util.List;
import java.util.Map;

public class Food {
    private final String id;
    private final String title;
    private final List<Map<String, Object>> ingredients;
    private final double price;
    private final String tribe;
    private final double basePrice;
    private final List<String> healthBenefits;
    private final String imageUrl;
    private final String preparationTime;
    private final List<Map<String, Object>> additionalIngredients;
    private boolean isFavorite;

    public Food(String id, String title, List<Map<String, Object>> ingredients, double price,
                String tribe, double basePrice, List<String> healthBenefits, String imageUrl,
                String preparationTime, List<Map<String, Object>> additionalIngredients, boolean isFavorite) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.price = price;
        this.tribe = tribe;
        this.basePrice = basePrice;
        this.healthBenefits = healthBenefits;
        this.imageUrl = imageUrl;
        this.preparationTime = preparationTime;
        this.additionalIngredients = additionalIngredients;
        this.isFavorite = isFavorite;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Map<String, Object>> getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }

    public String getTribe() {
        return tribe;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public List<String> getHealthBenefits() {
        return healthBenefits;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public List<Map<String, Object>> getAdditionalIngredients() {
        return additionalIngredients;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

}
