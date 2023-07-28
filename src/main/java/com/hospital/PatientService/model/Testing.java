package com.hospital.PatientService.model;

import com.hospital.PatientService.model.enums.testing.TestResult;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Testing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime dateAndTime = LocalDateTime.now();
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TestResult testResult = TestResult.UNPROCCESED;
    @Column(nullable = false)
    private String reason;
    @Column(nullable = false)
    private Boolean isDeleted;
    @OneToOne(mappedBy = "testing")
    private ScheduledTesting scheduledTesting;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id",nullable = false)
    private Patient patient;
}
