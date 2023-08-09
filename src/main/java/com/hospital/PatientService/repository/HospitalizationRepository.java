package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.HospitalRoom;
import com.hospital.PatientService.model.Hospitalization;
import com.hospital.PatientService.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface HospitalizationRepository extends JpaRepository<Hospitalization, Long>, JpaSpecificationExecutor<Hospitalization> {
    @Query(value = "select case when (count(h) > 0) then true else false end " +
            "from Hospitalization h where h.patient=:patient and h.dischargeDate is null")
    boolean isPatientAlreadyHospitalized(Patient patient);

    Optional<Hospitalization> findByHospitalRoomAndPatientAndDischargeDateIsNull(HospitalRoom hospitalRoom, Patient patient);

    @Query("select h.patient from Hospitalization h " +
            "where h.patient.id = :patientId and h.dischargeDate is null")
    Optional<Patient> getHospitalizedPatientByPatientId(@Param("patientId") UUID patientId);

    @Query("select h from Hospitalization h where h.patient.id = :patientId and h.dischargeDate is null")
    Optional<Hospitalization> getHospitalizationByPatientId(UUID patientId);
}
