package com.knowit.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;
    
    
    @JsonIgnoreProperties("customer")
    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    
    @JsonIgnoreProperties("customers")
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "adhar_number", unique = true, nullable = false)
    private String adharNumber;

    @Column(name = "driving_license_no", unique = true, nullable = false)
    private String drivingLicenseNo;

    @Column(name = "contact", nullable = false)
    private String contact;
}