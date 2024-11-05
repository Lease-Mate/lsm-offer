package com.lsm.ws.offer.domain.image;

import com.lsm.ws.offer.domain.offer.OfferImage;

import java.util.Optional;

public interface ImageRepository {

    OfferImage save(OfferImage offerImage);

    Optional<OfferImage> getById(String imageId);
}
