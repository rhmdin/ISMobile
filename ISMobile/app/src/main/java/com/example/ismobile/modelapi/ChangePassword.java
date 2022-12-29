package com.example.ismobile.modelapi;

import com.google.gson.annotations.SerializedName;

public class ChangePassword {

    @SerializedName("status")
    private static String status;
    @SerializedName("message")
    private static String message;

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        ChangePassword.status = status;
    }

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        ChangePassword.message = message;
    }
}
