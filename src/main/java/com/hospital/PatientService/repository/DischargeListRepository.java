package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.DischargeList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DischargeListRepository extends JpaRepository<DischargeList, Long> {
}
