package com.knowit.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car_rental_agency")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRentalAgency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agency_id")
    private int agencyId;

    
    @JsonIgnoreProperties("carRentalAgency")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;
    
    
    
    @JsonIgnoreProperties("carRentalAgencies")
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "gst_no", unique = true, nullable = false)
    private String gstNo;
    
    // @JsonIgnoreProperties("carRentalAgency")
    // @OneToMany(mappedBy = "carRentalAgency")
    // private List<Car> cars;
    
    
    // @JsonIgnoreProperties("bookings")
    // @OneToMany(mappedBy = "carRentalAgency")
    // private List<Booking> bookings;
}
