package com.knowit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowit.entities.City;
import com.knowit.repository.CityRepository;

@Service
public class CitiesSevice {

    @Autowired
    CityRepository crepo;

    public List<City> getAllCities() {
        return crepo.findAll();
    }
}
