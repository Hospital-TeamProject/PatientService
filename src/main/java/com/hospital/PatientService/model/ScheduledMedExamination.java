package com.hospital.PatientService.model;

import com.hospital.PatientService.model.enums.examination.ExaminationStatus;
import com.hospital.PatientService.model.enums.examination.PatientArrivalStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ScheduledMedExamination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private UUID doctorId;
    @Column(nullable = false)
    private UUID nurseId;
    @Column(nullable = false)
    private Date appointmentDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ExaminationStatus examinationStatus = ExaminationStatus.SCHEDULED;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PatientArrivalStatus patientArrivalStatus = PatientArrivalStatus.DID_NOT_SHOW_UP;
    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id", nullable = false)
    private Patient patient;
}
