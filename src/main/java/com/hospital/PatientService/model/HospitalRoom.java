package com.hospital.PatientService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
public class HospitalRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private UUID departmentId;
    @Column(nullable = false)
    private Integer roomNumber;
    @Column(nullable = false)
    private Integer capacity;
    @Column(nullable = false)
    private Integer curentNumberOfPatients;

    public void incrementCurrentNumberOfPatients() {
        this.curentNumberOfPatients++;
    }
    public void decrementCurrentNumberOfPatients() {
        this.curentNumberOfPatients--;
    }
}
