package com.lsm.ws.offer.domain.reservation;

import com.lsm.ws.offer.domain.Pagination;

import java.util.List;

public interface VisitRepository {

    List<Visit> getAcceptedVisitsByUserId(String userId, Pagination pagination);
}
