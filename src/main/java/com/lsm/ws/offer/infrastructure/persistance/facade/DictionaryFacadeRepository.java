package com.lsm.ws.offer.infrastructure.persistance.facade;

import com.lsm.ws.offer.domain.Language;
import com.lsm.ws.offer.domain.dictionary.Country;
import com.lsm.ws.offer.domain.dictionary.DictionaryRepository;
import com.lsm.ws.offer.infrastructure.persistance.jpa.CountryJpaRepository;
import com.lsm.ws.offer.infrastructure.persistance.model.CountryEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DictionaryFacadeRepository implements DictionaryRepository {

    private final CountryJpaRepository countryJpaRepository;

    public DictionaryFacadeRepository(CountryJpaRepository countryJpaRepository) {
        this.countryJpaRepository = countryJpaRepository;
    }

    @Override
    public List<Country> getCountries(Language lang) {
        Specification<CountryEntity> specification = Specification.where((root, query, cb) ->
                cb.equal(root.get("id").get("lang"), lang));
        return countryJpaRepository.findAll(specification)
                                   .stream().map(CountryEntity::toCountry)
                                   .toList();
    }
}
