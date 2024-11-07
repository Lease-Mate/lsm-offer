package com.lsm.ws.offer.infrastructure.persistance.jpa;

import com.lsm.ws.offer.infrastructure.persistance.model.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VisitReservationJpaRepository extends JpaRepository<VisitEntity, String>,
        JpaSpecificationExecutor<VisitEntity> {
}
