package com.hospital.PatientService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class AvailableTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime dateAndTime;
    @Column(nullable = false)
    private UUID departmentId;
    @Column(nullable = false)
    private Integer availableNursesNum;
    @Column(nullable = false)
    private Integer availableTermsNum = 0;
    @OneToMany(mappedBy = "availableTerm", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ScheduledTesting> scheduledTestings;
}
