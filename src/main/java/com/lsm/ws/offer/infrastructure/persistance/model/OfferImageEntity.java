package com.lsm.ws.offer.infrastructure.persistance.model;

import com.lsm.ws.offer.domain.offer.OfferImage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import org.hibernate.engine.jdbc.BlobProxy;

import java.sql.Blob;

@Entity
@Table(name = "offer_image")
public class OfferImageEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "offer_id")
    private String offerId;

    @Lob
    @Column(name = "image")
    private Blob image;

    @Column(name = "extension")
    private String extension;

    @Column(name = "order_no")
    private Integer order;

    public OfferImage toOfferImage() {
        try {
            return new OfferImage(
                    id,
                    offerId,
                    image.getBytes(1, (int) image.length()),
                    extension,
                    order
            );
        } catch (Exception e) {
            throw new RuntimeException("Error while accessing image", e);
        }
    }

    public void from(OfferImage offerImage) {
        setId(offerImage.id());
        setOfferId(offerImage.offerId());
        setImage(offerImage.image());
        setExtension(offerImage.extension());
        setOrder(offerImage.order());
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public void setImage(byte[] image) {
        this.image = BlobProxy.generateProxy(image);
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
