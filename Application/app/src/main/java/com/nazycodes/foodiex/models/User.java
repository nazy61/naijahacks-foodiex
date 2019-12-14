package com.nazycodes.foodiex.models;

public class User {
    private final String id;
    private final BankAccount bankAccount;
    private final String username;
    private final String email;
    private final String password;
    private final String phone;

    public User(String id, BankAccount bankAccount, String username, String email, String password, String phone) {
        this.id = id;
        this.bankAccount = bankAccount;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }
}
