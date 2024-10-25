package com.lsm.ws.offer.domain.dictionary;

import com.lsm.ws.offer.domain.Language;

import java.util.List;

public interface DictionaryRepository {

    List<Country> getCountries(Language lang);
}
