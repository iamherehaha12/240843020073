package com.knowit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;

    @Column(name = "city_name", unique = true, nullable = false)
    private String cityName;

//    @JsonIgnoreProperties("city")
//    @OneToMany(mappedBy = "city")
//    private List<Customer> customers;
//    
//    @JsonIgnoreProperties("city")
//    @OneToMany(mappedBy = "city")
//    private List<CarRentalAgency> carRentalAgencies;
}