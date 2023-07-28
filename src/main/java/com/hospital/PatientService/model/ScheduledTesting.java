package com.hospital.PatientService.model;

import com.hospital.PatientService.model.enums.examination.ExaminationStatus;
import com.hospital.PatientService.model.enums.examination.PatientArrivalStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ScheduledTesting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime dateAndTime;
    @Column(nullable = false)
    private UUID schedulerId;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ExaminationStatus examinationStatus = ExaminationStatus.SCHEDULED;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PatientArrivalStatus patientArrivalStatus = PatientArrivalStatus.DID_NOT_SHOW_UP;
    @Column
    private String note;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "testing_id", referencedColumnName = "id")
    private Testing testing;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "available_term_id", referencedColumnName = "id", nullable = false)
    private AvailableTerm availableTerm;
}
