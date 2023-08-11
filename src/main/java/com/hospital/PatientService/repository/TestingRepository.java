package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Testing;
import com.hospital.PatientService.model.enums.testing.TestResult;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

public interface TestingRepository extends JpaRepository<Testing, Long> {
    Page<Testing> findByTestResult(TestResult testResult, Pageable pageable);

    @Query(value = "select t from Testing t where t.patient.patientId = :patientId")
    List<Testing> findByPatientId(@Param("patientId") UUID patientId);

}
