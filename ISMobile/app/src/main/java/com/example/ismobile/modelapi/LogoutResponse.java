package com.example.ismobile.modelapi;

import com.google.gson.annotations.SerializedName;

public class LogoutResponse {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")
    private String message;
}
