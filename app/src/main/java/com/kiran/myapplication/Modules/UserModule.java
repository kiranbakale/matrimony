package com.kiran.myapplication.Modules;

public class UserModule {
    private String fullname;
    private String email;
    private String username;
    private String address;

    public UserModule(String fullname, String email, String username, String address) {
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

