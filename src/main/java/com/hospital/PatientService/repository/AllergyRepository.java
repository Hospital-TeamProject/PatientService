package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Allergy;
import com.hospital.PatientService.model.HealthRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface AllergyRepository extends JpaRepository<Allergy, Long> {
    Page<Allergy> findByHealthRecord(HealthRecord healthRecord, Pageable pageable);
    @Modifying
    @Query("update Allergy a set a.isDeleted = true where a.healthRecord=:healthRecord")
    Integer deleteAllergyWithMatchingHeartRecord(@Param("healthRecord") HealthRecord healthRecord);
}
