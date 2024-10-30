package com.lsm.ws.offer.configuration.exception;

public enum ErrorCode {

    OFFER_DOES_NOT_EXIST("001", "Offer does not exist"),
    COUNTRY_DOES_NOT_EXIST("002", "Country with code: {} does not exist"),
    REGION_DOES_NOT_EXIST("003", "Region with id: {} does not exist");

    private static final String MICROSERVICE_PREFIX = "lsm-offer-";
    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = MICROSERVICE_PREFIX + code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }
}
