package com.hospital.PatientService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;
    @Column(nullable = false)
    private UUID userId;
    @Column(nullable = false)
    private String visitorFirstName;
    @Column(nullable = false)
    private String visitorLastName;
    @Column(nullable = false)
    private String visitorJmbg;
    @Column(nullable = false)
    private Date date;
}
