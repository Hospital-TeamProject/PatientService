package com.hospital.PatientService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class MedicalExamination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date date;
    @Column
    private String mainSymptoms;
    @Column
    private String suggestedTherapy;
    @JsonIgnore
    @Column
    private Boolean deleted = false;
    @Column(nullable = false)
    private UUID userID;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "diagnosis_id",nullable = false)
    private Diagnosis diagnosis;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "health_record_id", nullable = false)
    private HealthRecord healthRecord;
}
