package com.knowit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowit.entities.City;
import com.knowit.entities.Customer;
import com.knowit.entities.User;
import com.knowit.repository.CityRepository;
import com.knowit.repository.CustomerRepository;
import com.knowit.repository.UserRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository cusrepo;

    @Autowired
    UserRepository urepo;

    @Autowired
    CityRepository ctyrepo;

    public Customer registerCustomer(String name, String email, String password, String address, String adharNumber, 
                                     String drivingLicenseNo, String contact, int cityId) {

                                        if(cusrepo.findByAdharNumber(adharNumber).isPresent()) {
                                            throw new RuntimeException("Adhar Number Already Registered");
                                        }

                                        if(cusrepo.findByDrivingLicenseNo(drivingLicenseNo).isPresent()) {
                                            throw new RuntimeException("Driving License Already Registered");
                                        }

                                        if(cusrepo.findByUser_Email(email).isPresent()) {
                                            throw new RuntimeException("User Already Registered");
                                        }

                                        User user = new User();
                                        user.setUserName(name);
                                        user.setEmail(email);
                                        user.setPassword(password);
                                        user=urepo.save(user);

                                        City city = ctyrepo.findById(cityId).orElseThrow(()->new RuntimeException("City not found"));

                                        Customer customer = new Customer();
                                        customer.setUser(user);
                                        customer.setCity(city);
                                        customer.setAddress(address);
                                        customer.setAdharNumber(adharNumber);
                                        customer.setDrivingLicenseNo(drivingLicenseNo);
                                        customer.setContact(contact);

                                        return cusrepo.save(customer);
                                     }

        // public Customer getCustomer(int id) {
        //     cusrepo.findById(id).get();
            
        // }
}
