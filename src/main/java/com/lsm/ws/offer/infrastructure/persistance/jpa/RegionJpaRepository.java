package com.lsm.ws.offer.infrastructure.persistance.jpa;

import com.lsm.ws.offer.infrastructure.persistance.model.dictionary.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RegionJpaRepository extends JpaRepository<RegionEntity, String>,
        JpaSpecificationExecutor<RegionEntity> {
}
