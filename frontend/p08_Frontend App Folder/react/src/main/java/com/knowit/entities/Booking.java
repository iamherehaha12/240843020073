package com.knowit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // @ManyToOne
    // @JoinColumn(name = "agency_id", nullable = false)
    // private CarRentalAgency carRentalAgency;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name = "booking_date", nullable = false)
    private java.sql.Date bookingDate;

    @Column(name = "rental_duration", nullable = false)
    private int rentalDuration;

    @Column(name = "journey_date", nullable = false)
    private java.sql.Date journeyDate;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;
}