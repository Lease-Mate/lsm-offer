package com.lsm.ws.offer.context.offer.dto;

import com.lsm.ws.offer.domain.offer.Offer;
import com.lsm.ws.offer.domain.offer.OfferStatus;

public class OfferDetailsDto extends OfferDto {

    public OfferStatus offerStatus;

    public static OfferDetailsDto from(Offer offer) {
        OfferDetailsDto dto = (OfferDetailsDto) OfferDto.from(offer);
        dto.offerStatus = offer.getStatus();
        return dto;
    }
}
