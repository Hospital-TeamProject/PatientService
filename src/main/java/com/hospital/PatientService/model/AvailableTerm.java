package com.hospital.PatientService.model;

import com.hospital.PatientService.model.enums.testing.Availability;
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
    @Enumerated(EnumType.STRING)
    private Availability availability = Availability.CAN_MAKE_AN_APPOINTMENT;
    @Column(nullable = false)
    private UUID departmentId;
    @Column(nullable = false)
    private Integer availableNursesNum;
    @Column(nullable = false)
    private Integer availableTermsNum = 0;
    @OneToMany(mappedBy = "availableTerm", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ScheduledTesting> scheduledTestings;

    public void incrementAvailableNurseNum() {
        this.availableNursesNum++;
    }

    public void decrementAvailableNurseNum() {
        this.availableNursesNum--;
    }

    public void incrementAvailableTermsNum() {
        this.availableTermsNum++;
    }

    public void decrementAvailableTermsNum() {
        this.availableTermsNum--;
    }

    public void addScheduledTesting(ScheduledTesting scheduledTesting) {
        this.scheduledTestings.add(scheduledTesting);
    }

    public void removeScheduledTesting(ScheduledTesting scheduledTesting) {
        this.scheduledTestings.remove(scheduledTesting);
    }
}
