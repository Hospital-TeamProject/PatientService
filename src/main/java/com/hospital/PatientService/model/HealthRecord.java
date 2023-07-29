package com.hospital.PatientService.model;

import com.hospital.PatientService.model.enums.healthrecord.BloodType;
import com.hospital.PatientService.model.enums.healthrecord.RHFactor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class HealthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date registrationDate = new Date(System.currentTimeMillis());
    @Column
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;
    @Column
    @Enumerated(EnumType.STRING)
    private RHFactor rhFactor;
    @Column
    private Boolean isDeleted = false;
    @OneToOne(mappedBy = "healthRecord", fetch = FetchType.LAZY)
    private Patient patient;
    @OneToMany(mappedBy = "healthRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Allergy> allergies;
    @OneToMany(mappedBy = "healthRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Operation> operations;
}
