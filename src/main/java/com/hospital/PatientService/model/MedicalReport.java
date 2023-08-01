package com.hospital.PatientService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class MedicalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;
    @Column(name = "doctor_id")
    private UUID doctorId;
    @Column(nullable = false)
    private Date date = new Date();
    @ManyToOne(fetch = FetchType.EAGER)
    private Diagnosis diagnosis;
    @Column(name = "proposed_therapy")
    private String proposedTherapy;
    @Column(nullable = false)
    private Boolean isDeleted = false;

}
