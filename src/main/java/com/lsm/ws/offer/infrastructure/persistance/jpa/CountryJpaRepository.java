package com.lsm.ws.offer.infrastructure.persistance.jpa;

import com.lsm.ws.offer.domain.Language;
import com.lsm.ws.offer.infrastructure.persistance.model.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CountryJpaRepository extends JpaRepository<CountryEntity, String>,
        JpaSpecificationExecutor<CountryEntity> {

    Optional<CountryEntity> findByIdIsoCodeAndIdLang(String isoCode, Language lang);
}
