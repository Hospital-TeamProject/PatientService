package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.HealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {
    Optional<HealthRecord> findById(Long id);
}
