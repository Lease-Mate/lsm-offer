package com.lsm.ws.offer.configuration.exception;

public enum ErrorCode {

    OFFER_DOES_NOT_EXIST("001", "Ogłoszenie nie istnieje"),
    COUNTRY_DOES_NOT_EXIST("002", "Kraj nie istnieje"),
    REGION_DOES_NOT_EXIST("003", "Region nie istnieje"),
    UNSUPPORTED_IMAGE_FORMAT("004", "Niedozwolony format obrazu, dozwolone formaty {}"),
    IMAGE_DOES_NOT_EXIST("005", "Obraz nie istnieje");

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
