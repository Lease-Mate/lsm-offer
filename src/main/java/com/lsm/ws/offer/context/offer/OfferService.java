package com.lsm.ws.offer.context.offer;

import com.lsm.ws.offer.configuration.exception.NoSuchOfferException;
import com.lsm.ws.offer.context.offer.dto.UpdateOfferRequest;
import com.lsm.ws.offer.domain.Pagination;
import com.lsm.ws.offer.domain.offer.Offer;
import com.lsm.ws.offer.domain.offer.OfferFilter;
import com.lsm.ws.offer.domain.offer.OfferRepository;
import com.lsm.ws.offer.domain.offer.OfferStatus;
import com.lsm.ws.offer.infrastructure.rest.context.RequestContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final RequestContext requestContext;

    public OfferService(OfferRepository offerRepository, RequestContext requestContext) {
        this.offerRepository = offerRepository;
        this.requestContext = requestContext;
    }

    public Offer createOffer() {
        var offer = new Offer(UUID.randomUUID().toString(), requestContext.userId());
        return offerRepository.save(offer);
    }

    public Offer updateOffer(String offerId, UpdateOfferRequest request) {
        var offer = offerRepository.findById(offerId)
                                   .filter(o -> requestContext.userId().equals(o.getAppUserId()))
                                   .orElseThrow(NoSuchOfferException::new);
        return offerRepository.save(request.toOffer(offer));
    }

    public List<Offer> search(OfferFilter filter, Pagination pagination) {
        return offerRepository.search(filter, pagination);
    }

    public void delete(String offerId) {
        var offer = offerRepository.findById(offerId)
                                   .filter(o -> requestContext.userId().equals(o.getAppUserId()))
                                   .orElseThrow(NoSuchOfferException::new);
        offerRepository.delete(offer);
    }

    public Offer publish(String offerId) {
        var offer = offerRepository.findById(offerId)
                                   .filter(o -> requestContext.userId().equals(o.getAppUserId()))
                                   .orElseThrow(NoSuchOfferException::new);
        offer.setStatus(OfferStatus.PUBLISHED);
        return offerRepository.save(offer);
    }

    public Offer findActive(String offerId) {
        return offerRepository.findById(offerId)
                              .filter(Offer::isActive)
                              .orElseThrow(NoSuchOfferException::new);
    }
}
