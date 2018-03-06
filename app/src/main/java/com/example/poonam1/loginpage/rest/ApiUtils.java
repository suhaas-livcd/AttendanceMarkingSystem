package com.example.poonam1.loginpage.rest;

/**
 * Created by suhaas on 3/6/2018.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://trackattendance.org/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
