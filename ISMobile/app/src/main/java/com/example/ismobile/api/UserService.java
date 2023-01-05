package com.example.ismobile.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import com.example.ismobile.data.Listmahasiswabimbingan;

import com.example.ismobile.modelapi.*;

public interface UserService {
    @FormUrlEncoded
    @POST("api/login")
    Call<Login> userLogin(
            @Field("username") String nip,
            @Field("password") String password
    );

    @POST("api/logout")
    Call<Logout> userLogout(
            @Header("Authorization") String token
    );

    @GET("api/me")
    Call<Profile> userProfile(
            @Header("Authorization") String token
    );
    @GET("api/admin")
    Call<Listmahasiswabimbingan> getListmahasiswabimbingan (
            @Header("Authorization") String token
    );

    @FormUrlEncoded
    @POST("api/me/update")
    Call<UpdateProfile> userProfileEdit(
            @Header("Authorization") String token,
            @Field("email") String email,
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("api/password")
    Call<ChangePassword> changePassword(
            @Header("Authorization") String token,
            @Field("old_password") String oldPass,
            @Field("new_password") String newPass,
            @Field("confirm_password") String confPass
    );




}
