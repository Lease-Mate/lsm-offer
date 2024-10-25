package com.lsm.ws.offer.configuration.exception;

public class NoSuchOfferException extends ValidationException {

    public NoSuchOfferException() {
        super(ErrorCode.OFFER_DOES_NOT_EXIST);
    }
}
