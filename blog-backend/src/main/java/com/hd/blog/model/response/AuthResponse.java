package com.hd.blog.model.response;

import org.springframework.beans.factory.annotation.Value;

public class AuthResponse {
    private String accessToken;
    private final String tokenType = "Bearer";

    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken( String accessToken ) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }
}
