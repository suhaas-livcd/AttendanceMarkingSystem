package com.example.MobileATS.Beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by suhaas on 3/7/2018.
 */

public class ListUserProfiles {

    @SerializedName("loginStatus")
    @Expose
    private String mLoginResponse;

    @SerializedName("loginResponse")
    private List<UserProfile> mUserProfileInfo;

    public List<UserProfile> getUserProfileInfo() {
        return mUserProfileInfo;
    }

    public void setUserProfileInfo(List<UserProfile> userProfileInfo) {
        this.mUserProfileInfo = userProfileInfo;
    }

    public String getLoginResponse() {
        return mLoginResponse;
    }

    public void setLoginResponse(String loginResponse) {
        this.mLoginResponse = loginResponse;
    }
}
