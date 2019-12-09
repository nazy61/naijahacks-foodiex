package com.nazycodes.foodiex.models;

public class Order {
    private final String id;
    private final Cart cart;

    public Order(String id, Cart cart) {
        this.id = id;
        this.cart = cart;
    }

    public String getId() {
        return id;
    }

    public Cart getCart() {
        return cart;
    }

    public void placeOrder(){}
}
