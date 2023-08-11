package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.DischargeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DischargeListRepository extends JpaRepository<DischargeList, Long>, JpaSpecificationExecutor<DischargeList> {
}
