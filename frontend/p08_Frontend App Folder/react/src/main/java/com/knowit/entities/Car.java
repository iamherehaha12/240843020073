package com.knowit.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // @JsonIgnoreProperties("cars")
    // @ManyToOne
    // @JoinColumn(name = "agency_id", nullable = false)
    // private CarRentalAgency carRentalAgency;

    @Column(name = "daily_rent", nullable = false)
    private double dailyRent;

    @Column(name = "registration_number", unique = true, nullable = false)
    private String registrationNumber;

    @Column(name = "kilometers_run")
    private Integer kilometersRun;

    @Column(name = "year_of_purchase")
    private Integer yearOfPurchase;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private CarModel carModel;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @OneToMany(mappedBy = "car")
    private List<CarAvailability> carAvailabilities;

    @OneToMany(mappedBy = "car")
    private List<Booking> bookings;
}