package com.hospital.PatientService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class PatientCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private UUID userId;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;
    @Column(nullable = false)
    private Date collectedInfoDate;
    @Column
    private String temperature;
    @Column
    private String bloodPressure;
    @Column
    private String pulse;
    @Column
    private String appliedTherapies;
}
