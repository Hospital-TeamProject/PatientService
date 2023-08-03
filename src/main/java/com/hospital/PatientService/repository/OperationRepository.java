package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
