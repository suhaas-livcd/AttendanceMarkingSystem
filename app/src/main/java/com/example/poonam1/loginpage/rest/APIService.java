package com.example.poonam1.loginpage.rest;

import com.example.poonam1.loginpage.Beans.UserCredentials;
import com.example.poonam1.loginpage.Beans.UserProfile;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by suhaas on 3/6/2018.
 */

public interface APIService {
    @POST("/donotdelete/login.php")
    @FormUrlEncoded
    Call<UserCredentials> authenticateUser(@Field("user_name") String mUserName,
                                           @Field("password") String mUserPassword,
                                           @Field("user_role") String mLoginType);
}