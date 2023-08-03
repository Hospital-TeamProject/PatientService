package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalReportRepository extends JpaRepository<MedicalReport, Long> {
}
