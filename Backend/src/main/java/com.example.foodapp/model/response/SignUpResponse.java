package com.example.foodapp.model.response;

public class SignUpResponse extends Response{

    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
