package com.lsm.ws.offer.infrastructure.persistance.model;

import com.lsm.ws.offer.domain.reservation.VisitStatus;
import com.lsm.ws.offer.domain.reservation.Visit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "visit_reservation")
public class VisitEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "offer_id")
    private String offerId;

    @Column(name = "app_user_id")
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private VisitStatus status;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "estimated_end_time")
    private LocalTime estimatedEndTime;

    public Visit toVisitReservation() {
        return new Visit(
                id,
                offerId,
                userId,
                status,
                date,
                time,
                estimatedEndTime
        );
    }

    public void from(Visit visit) {
        setId(visit.id());
        setOfferId(visit.offerId());
        setUserId(visit.userId());
        setStatus(visit.status());
        setDate(visit.date());
        setTime(visit.time());
        setEstimatedEndTime(visit.estimatedEndTime());
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStatus(VisitStatus status) {
        this.status = status;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setEstimatedEndTime(LocalTime estimatedEndTime) {
        this.estimatedEndTime = estimatedEndTime;
    }
}
