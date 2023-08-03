package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
