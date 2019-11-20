package com.hd.blog.security.jwt;

import com.hd.blog.model.BaseModel;

public class JwtAuthResponse extends BaseModel {

    private static final long serialVersionUID = -7349616337522564830L;

    private final String token;

    public JwtAuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}