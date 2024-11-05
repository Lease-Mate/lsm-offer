package com.lsm.ws.offer.infrastructure.persistance.jpa;

import com.lsm.ws.offer.infrastructure.persistance.model.OfferImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferImageJpaRepository extends JpaRepository<OfferImageEntity, String> {
}
