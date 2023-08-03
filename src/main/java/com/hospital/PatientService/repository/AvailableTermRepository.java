package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.AvailableTerm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableTermRepository extends JpaRepository<AvailableTerm, Long> {
}
