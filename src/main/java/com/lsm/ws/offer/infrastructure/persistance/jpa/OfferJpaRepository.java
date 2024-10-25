package com.lsm.ws.offer.infrastructure.persistance.jpa;

import com.lsm.ws.offer.infrastructure.persistance.model.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OfferJpaRepository extends JpaRepository<OfferEntity, String>, JpaSpecificationExecutor<OfferEntity> {
}
