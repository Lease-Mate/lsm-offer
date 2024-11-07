package com.lsm.ws.offer.context.visit;

import com.lsm.ws.offer.domain.Pagination;
import com.lsm.ws.offer.domain.reservation.Visit;
import com.lsm.ws.offer.infrastructure.persistance.facade.VisitFacadeRepository;
import com.lsm.ws.offer.infrastructure.rest.context.RequestContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {


    private final VisitFacadeRepository visitFacadeRepository;
    private final RequestContext requestContext;

    public VisitService(VisitFacadeRepository visitFacadeRepository, RequestContext requestContext) {
        this.visitFacadeRepository = visitFacadeRepository;
        this.requestContext = requestContext;
    }

    public List<Visit> getUserAcceptedVisits(Pagination pagination) {
        return visitFacadeRepository.getAcceptedVisitsByUserId(requestContext.userId(), pagination);
    }
}
