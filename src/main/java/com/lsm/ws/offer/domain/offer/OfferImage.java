package com.lsm.ws.offer.domain.offer;

public class OfferImage {

    private final String id;
    private final String offerId;
    private final byte[] imageData;
    private final String extension;
    private Integer order;

    public OfferImage(String id, String offerId, byte[] imageData, String extension, Integer order) {
        this.id = id;
        this.offerId = offerId;
        this.imageData = imageData;
        this.extension = extension;
        this.order = order;
    }

    public String id() {
        return id;
    }

    public String offerId() {
        return offerId;
    }

    public byte[] image() {
        return imageData;
    }

    public String extension() {
        return extension;
    }

    public Integer order() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
