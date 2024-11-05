package com.lsm.ws.offer.infrastructure.persistance.facade;

import com.lsm.ws.offer.domain.image.ImageRepository;
import com.lsm.ws.offer.domain.offer.OfferImage;
import com.lsm.ws.offer.infrastructure.persistance.jpa.OfferImageJpaRepository;
import com.lsm.ws.offer.infrastructure.persistance.model.OfferImageEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OfferImageFacadeRepository implements ImageRepository {

    private final OfferImageJpaRepository offerImageJpaRepository;

    public OfferImageFacadeRepository(OfferImageJpaRepository offerImageJpaRepository) {
        this.offerImageJpaRepository = offerImageJpaRepository;
    }

    @Override
    public OfferImage save(OfferImage offerImage) {
        var entity = new OfferImageEntity();
        entity.from(offerImage);
        return offerImageJpaRepository.save(entity)
                                      .toOfferImage();
    }

    @Override
    @Transactional
    public Optional<OfferImage> getById(String imageId) {
        return offerImageJpaRepository.findById(imageId)
                                      .map(OfferImageEntity::toOfferImage);
    }
}
