package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.ScheduledMedExamination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledMedExaminationRepository extends JpaRepository<ScheduledMedExamination, Long> {
}
