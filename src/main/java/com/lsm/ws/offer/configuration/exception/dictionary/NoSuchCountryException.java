package com.lsm.ws.offer.configuration.exception.dictionary;

import com.lsm.ws.offer.configuration.exception.ErrorCode;
import com.lsm.ws.offer.configuration.exception.ValidationException;

public class NoSuchCountryException extends ValidationException {

    public NoSuchCountryException(String countryCode) {
        super(ErrorCode.COUNTRY_DOES_NOT_EXIST, countryCode);
    }
}
