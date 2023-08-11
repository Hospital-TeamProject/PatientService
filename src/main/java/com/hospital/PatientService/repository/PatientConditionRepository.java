package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.PatientCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatientConditionRepository extends JpaRepository<PatientCondition, Long>, JpaSpecificationExecutor<PatientCondition> {
}
