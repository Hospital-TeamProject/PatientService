package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.HealthRecord;
import com.hospital.PatientService.model.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long>, JpaSpecificationExecutor<MedicalHistory> {
    List<MedicalHistory> findByHealthRecord(HealthRecord healthRecord);

    @Modifying
    @Query("update MedicalHistory m set m.deleted=true where m.healthRecord=:healthRecord")
    Integer updateDeletedAttributeByHealthRecord(@Param("healthRecordId") HealthRecord healthRecord);
}
