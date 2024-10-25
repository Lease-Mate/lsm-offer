package com.lsm.ws.offer.domain.offer;

import com.lsm.ws.offer.domain.Pagination;

import java.util.List;
import java.util.Optional;

public interface OfferRepository {

    Offer save(Offer offer);

    List<Offer> search(OfferFilter offerFilter, Pagination pagination);

    Optional<Offer> findById(String offerId);

    void delete(Offer offer);
}
