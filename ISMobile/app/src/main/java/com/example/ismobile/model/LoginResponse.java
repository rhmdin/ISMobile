package com.example.ismobile.model;
import com.google.gson.annotations.SerializedName;
public class LoginResponse {

    @SerializedName("authorisation")
    private LoginAuthorisation authorisation;

    @SerializedName("user")
    private LoginUser user;

    public LoginAuthorisation getAuthorisation() {
        return authorisation;
    }

    public void setAuthorisation(LoginAuthorisation authorisation) {
        this.authorisation = authorisation;
    }

    public LoginUser getUser() {
        return user;
    }

    public void setUser(LoginUser user) {
        this.user = user;
    }

}
