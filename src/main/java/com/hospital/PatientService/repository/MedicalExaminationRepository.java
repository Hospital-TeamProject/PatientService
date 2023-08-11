package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.HealthRecord;
import com.hospital.PatientService.model.MedicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long>, JpaSpecificationExecutor<MedicalExamination> {

    @Modifying
    @Query("update MedicalExamination m set m.deleted=true where m.healthRecord=:healthRecord")
    Integer updateDeletedAttributeByHealthRecord(@Param("healthRecord") HealthRecord healthRecord);

}
