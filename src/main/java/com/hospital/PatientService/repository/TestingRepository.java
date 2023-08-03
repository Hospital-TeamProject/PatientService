package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Testing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestingRepository extends JpaRepository<Testing, Long> {
}
