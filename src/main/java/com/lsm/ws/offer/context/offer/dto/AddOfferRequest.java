package com.lsm.ws.offer.context.offer.dto;

import com.lsm.ws.offer.domain.offer.Address;
import com.lsm.ws.offer.domain.offer.Offer;
import com.lsm.ws.offer.domain.offer.OfferStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Validated
public class AddOfferRequest {

    @NotEmpty
    public String title;

    @NotEmpty
    public String description;

    @NotNull
    public LocalDate availableFrom;

    @NotNull
    public BigDecimal rent;

    @Valid
    @NotNull
    public AddressDto address;

    @Positive
    @NotNull
    public Integer rooms;

    @Positive
    @NotNull
    public Double surfaceArea;

    @Max(100)
    public Integer floor;

    @Valid
    public GeoLocationDto geoLocation;

    public Offer toOffer(String appUserId) {
        return new Offer(
                UUID.randomUUID().toString(),
                appUserId,
                title,
                description,
                OfferStatus.UNPAID,
                availableFrom,
                rent,
                rooms,
                floor,
                surfaceArea,
                new Address(
                        geoLocation == null ? null : geoLocation.longitude,
                        geoLocation == null ? null : geoLocation.latitude,
                        address.city,
                        address.street,
                        address.zipCode,
                        address.buildingNumber,
                        address.apartmentNumber
                )
        );
    }
}
