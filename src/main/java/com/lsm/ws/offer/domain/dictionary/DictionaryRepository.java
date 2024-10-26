package com.lsm.ws.offer.domain.dictionary;

import com.lsm.ws.offer.domain.Language;

import java.util.List;
import java.util.Optional;

public interface DictionaryRepository {

    List<Country> getCountries(Language lang);

    Optional<Country> getCountry(String countryCode);

    List<Region> getRegions(String countryCode, Language lang);
}
