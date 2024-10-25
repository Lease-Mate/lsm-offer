package com.lsm.ws.offer.context.dictionary;

import com.lsm.ws.offer.domain.Language;
import com.lsm.ws.offer.domain.dictionary.Country;
import com.lsm.ws.offer.domain.dictionary.DictionaryRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Dictionary")
@RestController
@RequestMapping("/v1/api/offer/dictionary")
public class DictionaryEndpoint {

    private static final String COUNTRIES_SUMMARY = "Get supported countries";
    private static final String COUNTRIES_DESC = "returns supported countries";

    private final DictionaryRepository dictionaryRepository;

    public DictionaryEndpoint(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @Operation(summary = COUNTRIES_SUMMARY, description = COUNTRIES_DESC)
    @GetMapping("/countries/{lang}")
    public List<Country> countries(@PathVariable Language lang) {
        return dictionaryRepository.getCountries(lang);
    }
}
