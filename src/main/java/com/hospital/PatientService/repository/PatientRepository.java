package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {
    Optional<Patient> findByJmbg(String jmbg);

    Optional<Patient> findByJmbgAndDeleted(String jmbg, boolean deleted);

    Optional<Patient> findByPatientId(UUID patientId);

    Optional<Patient> findByPatientIdAndDeleted(UUID patientId, boolean deleted);
}
