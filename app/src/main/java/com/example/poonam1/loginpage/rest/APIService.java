package com.example.poonam1.loginpage.rest;

import com.example.poonam1.loginpage.Beans.ListUserProfiles;
import com.example.poonam1.loginpage.Beans.UserProfile;

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
    Call<ListUserProfiles> authenticateUser(@Field("user_name") String mUserName,
                                            @Field("password") String mUserPassword,
                                            @Field("user_role") String mLoginType);
}