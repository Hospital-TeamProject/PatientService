package com.hospital.PatientService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @Column
    private Boolean deleted = false;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "diagnosis_id", nullable = false)
    private Diagnosis diagnosis;
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "health_record_id", nullable = false)
    private HealthRecord healthRecord;
}
