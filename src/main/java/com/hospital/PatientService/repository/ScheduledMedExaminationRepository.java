package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Patient;
import com.hospital.PatientService.model.ScheduledMedExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScheduledMedExaminationRepository extends JpaRepository<ScheduledMedExamination, Long>, JpaSpecificationExecutor<ScheduledMedExamination> {
    Optional<ScheduledMedExamination> findByDoctorId(UUID doctorId);

    @Query(value = "select s from ScheduledMedExamination s where s.doctorId = :doctorId and s.appointmentDate = :appointmentDate")
    Optional<List<ScheduledMedExamination>> findSchedMedExamByDoctorIdAndBetweenGivenDates(@Param("doctorId") UUID doctorID,
                                                                                           @Param("appointmentDate") Date startDate,
                                                                                           @Param("endDate") Date endDate);


    @Query(value = "select s from ScheduledMedExamination s where s.patient = :patient and s.appointmentDate = :appointmentDate")
    Optional<List<ScheduledMedExamination>> findSchedMedExamByPatientAndBetweenGivenDates(@Param("patient") Patient patient,
                                                                                           @Param("appointmentDate") Date startDate,
                                                                                           @Param("endDate") Date endDate);

}
