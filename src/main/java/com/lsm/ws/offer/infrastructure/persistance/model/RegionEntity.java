package com.lsm.ws.offer.infrastructure.persistance.model;

import com.lsm.ws.offer.domain.Language;
import com.lsm.ws.offer.domain.dictionary.Region;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "region")
public class RegionEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "country_iso_code")
    private String countryIsoCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "lang")
    private Language lang;

    @Column(name = "name")
    private String name;

    public Region toRegion() {
        return new Region(id, name);
    }
}
