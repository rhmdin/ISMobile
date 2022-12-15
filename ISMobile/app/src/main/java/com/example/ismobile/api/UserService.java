package com.example.ismobile.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import com.example.ismobile.model.*;

public interface UserService {

    @POST("api/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
}
