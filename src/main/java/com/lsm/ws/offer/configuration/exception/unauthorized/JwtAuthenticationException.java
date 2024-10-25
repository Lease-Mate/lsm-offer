package com.lsm.ws.offer.configuration.exception.unauthorized;

public class JwtAuthenticationException extends UnauthorizedException {

    public JwtAuthenticationException(String message) {
        super(message);
    }
}
