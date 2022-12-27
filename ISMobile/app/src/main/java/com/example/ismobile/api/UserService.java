package com.example.ismobile.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

import com.example.ismobile.modelapi.*;

public interface UserService {

    @POST("api/login")
    Call<LoginResponse> userLogin(
            @Body LoginRequest loginRequest
    );

    @POST("api/logout")
    Call<LogoutResponse> userLogout(
            @Header("Authorization") String token
    );

    @GET("api/me")
    Call<ProfileResponse> userProfile(
            @Header("Authorization") String token
    );

    @POST("api/me/update")
    Call<ProfileResponse> userEditProfile(
            @Header("Authorization") String token
    );

    @POST("api/password")
    Call<ProfileResponse> userEditPassword(
            @Header("Authorization") String token
    );

}
