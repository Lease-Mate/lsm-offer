package com.lsm.ws.offer.domain.reservation;

import java.time.LocalDate;
import java.time.LocalTime;

public class Visit {

    private final String id;
    private final String offerId;
    private final String userId;
    private final LocalDate date;
    private final LocalTime time;
    private LocalTime estimatedEndTime;
    private VisitStatus status;

    public Visit(
            String id,
            String offerId,
            String userId,
            VisitStatus status,
            LocalDate date,
            LocalTime time,
            LocalTime estimatedEndTime) {
        this.id = id;
        this.offerId = offerId;
        this.userId = userId;
        this.status = status;
        this.date = date;
        this.time = time;
        this.estimatedEndTime = estimatedEndTime;
    }

    public String id() {
        return id;
    }

    public String offerId() {
        return offerId;
    }

    public String userId() {
        return userId;
    }

    public LocalDate date() {
        return date;
    }

    public LocalTime time() {
        return time;
    }

    public LocalTime estimatedEndTime() {
        return estimatedEndTime;
    }

    public void setEstimatedEndTime(LocalTime estimatedEndTime) {
        this.estimatedEndTime = estimatedEndTime;
    }

    public VisitStatus status() {
        return status;
    }

    public void setStatus(VisitStatus status) {
        this.status = status;
    }
}
