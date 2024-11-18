package com.lsm.ws.offer.context.offer.dto;

import com.lsm.ws.offer.domain.offer.Offer;
import com.lsm.ws.offer.domain.offer.OfferStatus;

public class OfferDetailsDto extends OfferDto {

    public OfferStatus offerStatus;

    public static OfferDetailsDto from(Offer offer) {
        OfferDetailsDto dto =  new OfferDetailsDto();
        dto.id = offer.getId();
        dto.appUserId = offer.getAppUserId();
        dto.title = offer.getTitle();
        dto.description = offer.getDescription();
        dto.availableFrom = offer.getAvailableFrom();
        dto.rent = offer.getRent();
        dto.rooms = offer.getRooms();
        dto.floor = offer.getFloor();
        dto.surfaceArea = offer.getSurfaceArea();
        dto.address = offer.getAddress();
        dto.offerStatus = offer.getStatus();
        return dto;
    }
}
