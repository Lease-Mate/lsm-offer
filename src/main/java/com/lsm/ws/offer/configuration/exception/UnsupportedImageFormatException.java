package com.lsm.ws.offer.configuration.exception;

public class UnsupportedImageFormatException extends ValidationException {

    public UnsupportedImageFormatException(String supportedFormats) {
        super(ErrorCode.UNSUPPORTED_IMAGE_FORMAT, supportedFormats);
    }
}
