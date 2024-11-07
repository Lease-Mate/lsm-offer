package com.lsm.ws.offer.infrastructure.persistance.facade;

import com.lsm.ws.offer.domain.Pagination;
import com.lsm.ws.offer.domain.reservation.Visit;
import com.lsm.ws.offer.domain.reservation.VisitRepository;
import com.lsm.ws.offer.infrastructure.persistance.jpa.VisitReservationJpaRepository;
import com.lsm.ws.offer.infrastructure.persistance.model.VisitEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VisitFacadeRepository implements VisitRepository {

    private final VisitReservationJpaRepository visitReservationJpaRepository;

    public VisitFacadeRepository(VisitReservationJpaRepository visitReservationJpaRepository) {
        this.visitReservationJpaRepository = visitReservationJpaRepository;
    }

    @Override
    public List<Visit> getAcceptedVisitsByUserId(String userId, Pagination pagination) {
        Specification<VisitEntity> specification = Specification.where(null);

        var pageable = PageRequest.of(pagination.getPage(), pagination.getSize(),
                Sort.by(Sort.Direction.DESC, "date", "time"));

        return visitReservationJpaRepository.findAll(specification, pageable)
                                            .map(VisitEntity::toVisitReservation)
                                            .stream().toList();
    }
}
