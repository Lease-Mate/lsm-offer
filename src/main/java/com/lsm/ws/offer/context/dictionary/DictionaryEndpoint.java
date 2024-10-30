package com.lsm.ws.offer.context.dictionary;

import com.lsm.ws.offer.configuration.exception.dictionary.NoSuchCountryException;
import com.lsm.ws.offer.configuration.exception.dictionary.NoSuchRegionException;
import com.lsm.ws.offer.domain.Language;
import com.lsm.ws.offer.domain.dictionary.City;
import com.lsm.ws.offer.domain.dictionary.Country;
import com.lsm.ws.offer.domain.dictionary.DictionaryRepository;
import com.lsm.ws.offer.domain.dictionary.Region;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Dictionary")
@RestController
@RequestMapping("/v1/api/offer/dictionary")
public class DictionaryEndpoint {

    private static final String COUNTRIES_SUMMARY = "Get supported countries";
    private static final String COUNTRIES_DESC = "returns supported countries";
    private static final String REGIONS_SUMMARY = "Get supported regions";
    private static final String REGIONS_DESC = "returns supported regions";
    private static final String CITIES_SUMMARY = "Get supported cities";
    private static final String CITIES_DESC = "returns supported cities";

    private final DictionaryRepository dictionaryRepository;

    public DictionaryEndpoint(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @Operation(summary = COUNTRIES_SUMMARY, description = COUNTRIES_DESC)
    @GetMapping("/countries")
    public List<Country> countries(@RequestHeader @NotNull Language lang) {
        return dictionaryRepository.getCountries(lang);
    }

    @Operation(summary = REGIONS_SUMMARY, description = REGIONS_DESC)
    @GetMapping("/countries/{countryCode}/regions")
    public List<Region> regions(@PathVariable @NotEmpty String countryCode,
                                @RequestHeader @NotEmpty Language lang) {

        dictionaryRepository.getCountry(countryCode)
                            .orElseThrow(() -> new NoSuchCountryException(countryCode));

        return dictionaryRepository.getRegions(countryCode, lang);
    }

    @Operation(summary = CITIES_SUMMARY, description = CITIES_DESC)
    @GetMapping("/regions/{regionId}/cities")
    public List<City> cities(@PathVariable @NotEmpty String regionId,
                             @RequestHeader @NotNull Language lang) {

        dictionaryRepository.getRegion(regionId)
                            .orElseThrow(() -> new NoSuchRegionException(regionId));

        return dictionaryRepository.getCities(regionId, lang);
    }
}
