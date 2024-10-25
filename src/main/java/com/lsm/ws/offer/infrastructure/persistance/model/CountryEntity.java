package com.lsm.ws.offer.infrastructure.persistance.model;

import com.lsm.ws.offer.domain.dictionary.Country;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class CountryEntity {

    @EmbeddedId
    private CountryId id;

    @Column(name = "name")
    private String name;

    public Country toCountry() {
        return new Country(id.getIsoCode(), name);
    }
}
