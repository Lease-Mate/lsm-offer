package com.lsm.ws.offer.configuration.exception.dto;

public class ErrorCodeResponse extends ErrorResponse {

    public final String code;

    public ErrorCodeResponse(String code, String message) {
        super(message);
        this.code = code;
    }
}
