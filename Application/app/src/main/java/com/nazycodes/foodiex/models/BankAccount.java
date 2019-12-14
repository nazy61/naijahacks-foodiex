package com.nazycodes.foodiex.models;

public class BankAccount {
    private final String id;
    private final String userId;

    public BankAccount(String id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }


}
