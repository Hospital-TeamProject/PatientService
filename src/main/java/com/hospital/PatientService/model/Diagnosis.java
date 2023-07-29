package com.hospital.PatientService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    @Column
    private String description;
    @OneToMany(mappedBy = "diagnosis", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MedicalExamination> medicalExaminations;
    @OneToMany(mappedBy = "diagnosis", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MedicalHistory> medicalHistories;

}
