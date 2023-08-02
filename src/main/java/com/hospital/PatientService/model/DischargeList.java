package com.hospital.PatientService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class DischargeList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospitalization_id", referencedColumnName = "id", nullable = false)
    private Hospitalization hospitalization;
    @Column(nullable = false)
    private String conclusion;
    private String therapy;
    @Column(nullable = false)
    private UUID doctorId;
    @Column(nullable = false)
    private UUID departmentId;
    @Column(nullable = false)
    private Date date = new Date();
}
