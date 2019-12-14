package com.nazycodes.foodiex.models;

import java.util.List;

public class Cart {
    private final String id;
    private final List<CartItem> items;
    private final List<CartItem> orderItems;

    public Cart(String id, List<CartItem> items, List<CartItem> orderItems) {
        this.id = id;
        this.items = items;
        this.orderItems = orderItems;
    }

    public String getId() {
        return id;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public List<CartItem> getOrderItems() {
        return orderItems;
    }

    public void order(){}

    public void addOrderItem(){}

    public void removeOrderItem(){}

    public void deleteCartItem(){}
}
