package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Visit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Query(value = "select v from Visit v where v.patient.patientId = :patientId")
    Page<Visit> findByPatientId(@Param("patientId") UUID patientId, Pageable pageable);
}
