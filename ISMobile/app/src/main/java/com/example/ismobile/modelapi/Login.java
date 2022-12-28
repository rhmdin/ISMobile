package com.example.ismobile.modelapi;
import com.google.gson.annotations.SerializedName;
public class Login {

    @SerializedName("status")
    private String status;

    @SerializedName("user")
    private LoginUser user;

    @SerializedName("authorisation")
    private LoginAuthorisation authorisation;


    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public LoginUser getUser() {
        return user;
    }
    public void setUser(LoginUser user) {
        this.user = user;
    }

    public LoginAuthorisation getAuthorisation() {
        return authorisation;
    }
    public void setAuthorisation(LoginAuthorisation authorisation) {
        this.authorisation = authorisation;
    }

}
