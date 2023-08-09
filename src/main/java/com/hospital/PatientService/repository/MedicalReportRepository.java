package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedicalReportRepository extends JpaRepository<MedicalReport, Long>, JpaSpecificationExecutor<MedicalReport> {
}
