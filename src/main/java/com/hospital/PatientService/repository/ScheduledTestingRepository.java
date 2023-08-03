package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.ScheduledTesting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledTestingRepository extends JpaRepository<ScheduledTesting, Long> {
}
