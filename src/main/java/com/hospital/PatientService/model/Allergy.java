package com.hospital.PatientService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Allergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Boolean isDeleted = false;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "health_record_id", nullable = false)
    private HealthRecord healthRecord;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "allergen_id", nullable = false)
    private Allergen allergen;


}
