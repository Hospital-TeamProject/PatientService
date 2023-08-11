package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Patient;
import com.hospital.PatientService.model.ScheduledTesting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ScheduledTestingRepository extends JpaRepository<ScheduledTesting, Long>, JpaSpecificationExecutor<ScheduledTesting> {
    @Query(value = "select s from ScheduledTesting s where s.patient = :patient " +
            "and s.dateAndTime>=:startDate and s.dateAndTime<=:endDate")
    List<ScheduledTesting> findByPatientAndBetweenGivenDates(@Param("patient") Patient patient,
                                                             @Param("startDate") Date startDate,
                                                             @Param("endDate") Date endDate);
}
