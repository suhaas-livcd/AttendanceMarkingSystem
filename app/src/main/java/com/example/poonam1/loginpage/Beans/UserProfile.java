package com.example.poonam1.loginpage.Beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by suhaas on 3/6/2018.
 */

public class UserProfile {
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("Reg_No")
    @Expose
    private String regNo;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Department")
    @Expose
    private String department;
    @SerializedName("Mentor")
    @Expose
    private String mentor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }


    @Override
    public String toString() {
        return UserProfile.class.getSimpleName()+"{"+
                "response : "+response+  "id : "+id+"username : "+username+"type : "+
                type+"regNo : "+regNo+"name : "+name+"department : "+department+
                "mentor : "+mentor+"}";
    }
}
