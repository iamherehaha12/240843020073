package com.knowit.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mode_of_payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModeOfPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mode_id")
    private int modeId;

    @Column(name = "mode_name", nullable = false)
    private String modeName;

    @OneToMany(mappedBy = "modeOfPayment")
    private List<Payment> payments;
}