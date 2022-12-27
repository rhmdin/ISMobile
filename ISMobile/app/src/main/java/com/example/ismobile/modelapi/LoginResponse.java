package com.example.ismobile.modelapi;
import com.google.gson.annotations.SerializedName;
public class LoginResponse {

    @SerializedName("authorisation")
    private LoginAuthorisation authorisation;

    @SerializedName("user")
    private LoginUser user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @SerializedName("status")
    private String status;

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
