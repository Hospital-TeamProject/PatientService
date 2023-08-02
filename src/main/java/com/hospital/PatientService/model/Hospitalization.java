package com.hospital.PatientService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Hospitalization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "hospital_room_id", referencedColumnName = "id", nullable = false)
    private HospitalRoom hospitalRoom;
    @Column(nullable = false)
    private UUID doctorId;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "diagnosis_id", referencedColumnName = "id", nullable = false)
    private Diagnosis diagnosis;
    @Column
    private Date dischargeDate;
    @OneToOne(mappedBy = "hospitalization", fetch = FetchType.LAZY)
    private DischargeList dischargeList;
}
