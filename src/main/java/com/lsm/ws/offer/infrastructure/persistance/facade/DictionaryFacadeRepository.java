package com.lsm.ws.offer.infrastructure.persistance.facade;

import com.lsm.ws.offer.domain.Language;
import com.lsm.ws.offer.domain.dictionary.City;
import com.lsm.ws.offer.domain.dictionary.Country;
import com.lsm.ws.offer.domain.dictionary.DictionaryRepository;
import com.lsm.ws.offer.domain.dictionary.Region;
import com.lsm.ws.offer.infrastructure.persistance.jpa.CityJpaRepository;
import com.lsm.ws.offer.infrastructure.persistance.jpa.CountryJpaRepository;
import com.lsm.ws.offer.infrastructure.persistance.jpa.RegionJpaRepository;
import com.lsm.ws.offer.infrastructure.persistance.model.dictionary.CityEntity;
import com.lsm.ws.offer.infrastructure.persistance.model.dictionary.CountryEntity;
import com.lsm.ws.offer.infrastructure.persistance.model.dictionary.RegionEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DictionaryFacadeRepository implements DictionaryRepository {

    private final CountryJpaRepository countryJpaRepository;
    private final RegionJpaRepository regionJpaRepository;
    private final CityJpaRepository cityJpaRepository;

    public DictionaryFacadeRepository(CountryJpaRepository countryJpaRepository,
                                      RegionJpaRepository regionJpaRepository, CityJpaRepository cityJpaRepository) {
        this.countryJpaRepository = countryJpaRepository;
        this.regionJpaRepository = regionJpaRepository;
        this.cityJpaRepository = cityJpaRepository;
    }

    @Override
    public List<Country> getCountries(Language lang) {
        Specification<CountryEntity> hasLang = Specification.where((root, query, cb) ->
                cb.equal(root.get("id").get("lang"), lang));
        return countryJpaRepository.findAll(hasLang)
                                   .stream().map(CountryEntity::toCountry)
                                   .toList();
    }

    @Override
    public Optional<Country> getCountry(String countryCode) {

        return countryJpaRepository.findByIdIsoCodeAndIdLang(countryCode, Language.EN)
                                   .map(CountryEntity::toCountry);
    }

    @Override
    public List<Region> getRegions(String countryCode, Language lang) {
        Specification<RegionEntity> hasCountryCode = Specification.where((root, query, cb) ->
                cb.equal(root.get("countryIsoCode"), countryCode));
        Specification<RegionEntity> hasLang = Specification.where((root, query, cb) ->
                cb.equal(root.get("lang"), lang));
        var sort = Sort.by(Sort.Direction.ASC, "name");
        return regionJpaRepository.findAll(hasCountryCode.and(hasLang), sort)
                                  .stream().map(RegionEntity::toRegion)
                                  .toList();
    }

    @Override
    public Optional<Region> getRegion(String regionId) {
        return regionJpaRepository.findById(regionId)
                                  .map(RegionEntity::toRegion);
    }

    @Override
    public List<City> getCities(String regionId, Language lang) {
        Specification<CityEntity> hasCountryIsoCode = Specification.where((root, query, cb) ->
                cb.equal(root.get("regionId"), regionId));
        return cityJpaRepository.findAll(hasCountryIsoCode.and(hasLang(lang)), sortByName())
                                .stream().map(CityEntity::toCity)
                                .toList();
    }

    private <T> Specification<T> hasLang(Language lang) {
        return (root, query, cb) -> cb.equal(root.get("lang"), lang);
    }

    private Sort sortByName() {
        return Sort.by(Sort.Direction.ASC, "name");
    }
}
