package com.lsm.ws.offer.infrastructure.persistance.jpa;

import com.lsm.ws.offer.infrastructure.persistance.model.dictionary.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityJpaRepository extends JpaRepository<CityEntity, String>, JpaSpecificationExecutor<CityEntity> {
}
