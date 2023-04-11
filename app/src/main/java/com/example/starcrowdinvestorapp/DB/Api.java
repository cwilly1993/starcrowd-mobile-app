package com.example.starcrowdinvestorapp.DB;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    @FormUrlEncoded
    @POST("userLogin")
    Call<UserResponse> userLogin(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("getUser/{id}")
    Call<UserResponse> getUserById(@Path("id") int id);
}
