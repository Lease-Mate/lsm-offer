package com.lsm.ws.offer.configuration.exception.unauthorized;

public class JwtTokenBlacklistedException extends UnauthorizedException {

    private static final String TOKEN_BLACKLISTED = "Token blacklisted";

    public JwtTokenBlacklistedException() {
        super(TOKEN_BLACKLISTED);
    }
}
