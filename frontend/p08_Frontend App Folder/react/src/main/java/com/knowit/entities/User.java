package com.knowit.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @JsonIgnoreProperties("role_id")
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Roles role;
    
    @JsonIgnoreProperties("user")
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Customer customer;
    
    
    @JsonIgnoreProperties("user")
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private CarRentalAgency carRentalAgency;
}