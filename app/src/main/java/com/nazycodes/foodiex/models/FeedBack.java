package com.nazycodes.foodiex.models;

public class FeedBack {
    private final String id;
    private final String message;
    private final String userId;
    private final String response;
    private final boolean isAnswered;
    private final String imageUrl;

    public FeedBack(String id, String message, String userId, String response, boolean isAnswered, String imageUrl) {
        this.id = id;
        this.message = message;
        this.userId = userId;
        this.response = response;
        this.isAnswered = isAnswered;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getUserId() {
        return userId;
    }

    public String getResponse() {
        return response;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
