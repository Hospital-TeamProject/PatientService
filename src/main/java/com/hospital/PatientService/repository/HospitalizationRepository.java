package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalizationRepository extends JpaRepository<Hospitalization, Long> {
}
