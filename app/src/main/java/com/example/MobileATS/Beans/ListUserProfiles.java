package com.example.MobileATS.Beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by suhaas on 3/7/2018.
 */

public class ListUserProfiles {

    @SerializedName("response")
    @Expose
    private String response;

    @SerializedName("loginResponse")
    private List<UserProfile> results;

    public List<UserProfile> getResults() {
        return results;
    }

    public void setResults(List<UserProfile> results) {
        this.results = results;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
