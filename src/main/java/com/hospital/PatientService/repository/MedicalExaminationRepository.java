package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.MedicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long> {
}
