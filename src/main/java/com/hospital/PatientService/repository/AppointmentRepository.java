package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
