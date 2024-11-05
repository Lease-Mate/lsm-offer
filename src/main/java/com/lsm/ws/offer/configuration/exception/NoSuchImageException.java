package com.lsm.ws.offer.configuration.exception;

public class NoSuchImageException extends ValidationException {

    public NoSuchImageException() {
        super(ErrorCode.IMAGE_DOES_NOT_EXIST);
    }
}
