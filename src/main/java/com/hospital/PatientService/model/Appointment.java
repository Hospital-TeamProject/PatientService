package com.hospital.PatientService.model;

import com.hospital.PatientService.model.enums.appointment.AppointmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private UUID departmentId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;
    @Column(nullable = false)
    private UUID employeeId;
    @Column(nullable = false)
    private Date appointmentDate;
    private AppointmentStatus appointmentStatus = AppointmentStatus.SCHEDULED;
}
