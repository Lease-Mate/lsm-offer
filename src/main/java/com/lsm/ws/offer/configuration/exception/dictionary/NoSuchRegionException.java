package com.lsm.ws.offer.configuration.exception.dictionary;

import com.lsm.ws.offer.configuration.exception.ErrorCode;
import com.lsm.ws.offer.configuration.exception.ValidationException;

public class NoSuchRegionException extends ValidationException {

    public NoSuchRegionException() {
        super(ErrorCode.REGION_DOES_NOT_EXIST);
    }
}
