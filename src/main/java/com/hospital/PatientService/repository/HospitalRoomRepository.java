package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.HospitalRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRoomRepository extends JpaRepository<HospitalRoom, Long> {
}
