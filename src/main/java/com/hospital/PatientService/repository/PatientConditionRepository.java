package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.PatientCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientConditionRepository extends JpaRepository<PatientCondition, Long> {
}
