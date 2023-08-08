package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Appointment;
import com.hospital.PatientService.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>, JpaSpecificationExecutor<Appointment> {
    @Query(value = "select case when (count(a) > 0) then true else false end " +
            "from Appointment a where a.patient=:patient and a.appointmentDate between :startDate and :endDate")
    boolean patientHasAppointmentBetweenDates(@Param("patient") Patient patient,
                                              @Param("startDate") Date startDate,
                                              @Param("endDate") Date endDate);

    @Query("select a from Appointment a where a.patient=:patient and a.departmentId=:departmentId and a.appointmentDate between :startDate and :endDate")
    Optional<Appointment> findByPatientAndDepartmentIdAndAppointmentDateBetween(@Param("patient") Patient patient,
                                                                                @Param("departmentId") UUID departmentId,
                                                                                @Param("startDate") Date startDate,
                                                                                @Param("endDate") Date endDate);
}
