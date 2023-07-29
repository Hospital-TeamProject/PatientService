package com.hospital.PatientService.model;

import com.hospital.PatientService.model.enums.medicalhistory.TreatmentResult;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date illnessStart;

    @Column
    private Date illnessEnd;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TreatmentResult treatmentResult;

    @Column(nullable = false)
    private String currentStateDescription;
}
