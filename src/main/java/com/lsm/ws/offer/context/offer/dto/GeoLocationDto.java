package com.lsm.ws.offer.context.offer.dto;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

@Validated
public class GeoLocationDto {

    @NotEmpty
    public String longitude;

    @NotEmpty
    public String latitude;
}
