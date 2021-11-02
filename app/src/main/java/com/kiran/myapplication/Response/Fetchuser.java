package com.kiran.myapplication.Response;

import com.google.gson.annotations.SerializedName;
import com.kiran.myapplication.Modules.UserModule;

import java.util.List;

public class Fetchuser {

    @SerializedName("user")
    List<UserModule> userList;
    String error;

    public Fetchuser(List<UserModule> userList, String error) {
        this.userList = userList;
        this.error = error;
    }

    public List<UserModule> getUserList() {
        return userList;
    }

    public void setUserList(List<UserModule> userList) {
        this.userList = userList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}


