package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.HealthRecord;
import com.hospital.PatientService.model.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    Page<Operation> findByHealthRecord(HealthRecord healthRecord, Pageable pageable);
    @Modifying
    @Query("update Operation o set o.isDeleted=true where o.healthRecord=:healthRecord")
    Integer updateDeletedAttributeByHealthRecord(@Param("healthRecord") HealthRecord healthRecord);
}
