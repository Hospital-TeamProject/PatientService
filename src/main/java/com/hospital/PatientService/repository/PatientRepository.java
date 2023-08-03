package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
