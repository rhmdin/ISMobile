package com.example.ismobile.model;

import com.google.gson.annotations.SerializedName;

public class LoginAuthorisation {
    @SerializedName("token")
    private String token;
    @SerializedName("type")
    private String type;
}
