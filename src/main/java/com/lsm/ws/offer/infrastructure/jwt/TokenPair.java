package com.lsm.ws.offer.infrastructure.jwt;

public class TokenPair {

    public final String authToken;
    public final String refreshToken;

    public TokenPair(String authToken, String refreshToken) {
        this.authToken = authToken;
        this.refreshToken = refreshToken;
    }
}
