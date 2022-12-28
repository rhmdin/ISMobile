package com.example.ismobile.modelapi;

import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String username;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("email_verified_at")
    private Object email_verified_at;
    @SerializedName("two_factor_secret")
    private Object two_factor_secret;
    @SerializedName("two_factor_recovery_codes")
    private Object two_factor_recovery_codes;
    @SerializedName("type")
    private int type;
    @SerializedName("active")
    private int active;
    @SerializedName("avatar")
    private Object avatar;
    @SerializedName("role")
    private Object role;
    @SerializedName("token")
    private Object token;
    @SerializedName("current_team_id")
    private Object current_team_id;
    @SerializedName("profile_photo_path")
    private Object profile_photo_path;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(Object email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public Object getTwo_factor_secret() {
        return two_factor_secret;
    }

    public void setTwo_factor_secret(Object two_factor_secret) {
        this.two_factor_secret = two_factor_secret;
    }

    public Object getTwo_factor_recovery_codes() {
        return two_factor_recovery_codes;
    }

    public void setTwo_factor_recovery_codes(Object two_factor_recovery_codes) {
        this.two_factor_recovery_codes = two_factor_recovery_codes;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Object getAvatar() {
        return avatar;
    }

    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }

    public Object getRole() {
        return role;
    }

    public void setRole(Object role) {
        this.role = role;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }

    public Object getCurrent_team_id() {
        return current_team_id;
    }

    public void setCurrent_team_id(Object current_team_id) {
        this.current_team_id = current_team_id;
    }

    public Object getProfile_photo_path() {
        return profile_photo_path;
    }

    public void setProfile_photo_path(Object profile_photo_path) {
        this.profile_photo_path = profile_photo_path;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
