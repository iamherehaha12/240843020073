package com.knowit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knowit.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    //To Ensure No Duplicate Adhar Number is Registered,ensure Driving License is Unique,validate User with same email is already registered
    Optional<Customer> findByAdharNumber(String adharNumber);

    Optional<Customer> findByDrivingLicenseNo(String drivingLicenseNo);

    Optional<Customer> findByUser_Email(String email);
}
