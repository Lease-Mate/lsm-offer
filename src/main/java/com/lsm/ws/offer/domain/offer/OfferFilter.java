package com.lsm.ws.offer.domain.offer;

import java.math.BigDecimal;
import java.time.LocalDate;

public record OfferFilter(OfferStatus status,
                          String country,
                          String city,
                          LocalDate availableFrom,
                          LocalDate availableTo,
                          BigDecimal rentFrom,
                          BigDecimal rentTo,
                          Double surfaceAreaFrom,
                          Double surfaceAreaTo,
                          String userId) {

    public static OfferFilterBuilder builder() {
        return new OfferFilterBuilder();
    }
}
