package com.nazycodes.foodiex.models;

public class CartItem {
    private final String id;
    private final Food food;
    private final double price;
    private final int quantity;

    public CartItem(String id, Food food, double price, int quantity) {
        this.id = id;
        this.food = food;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public Food getFood() {
        return food;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addToCart(){}

    public void increaseQuantity(){}

    public void reduceQuantity(){}
}
