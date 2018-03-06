package com.example.poonam1.loginpage.Beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by suhaas on 3/7/2018.
 */

public class ListUserProfiles {
    public List<UserProfile> getResults() {
        return results;
    }

    public void setResults(List<UserProfile> results) {
        this.results = results;
    }

    @SerializedName("loginResponse")
    private List<UserProfile> results;
}
