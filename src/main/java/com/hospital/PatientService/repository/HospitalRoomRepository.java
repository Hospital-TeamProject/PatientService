package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.HospitalRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface HospitalRoomRepository extends JpaRepository<HospitalRoom, Long> {
    Page<HospitalRoom> findByDepartmentId(UUID departmentId, Pageable pageable);

    @Query("select sum(capacity) from HospitalRoom where departmentId=:departmentId")
    int countTotalBedsByDepartmentId(@Param("departmentId") UUID departmentId);

    @Query("select sum(curentNumberOfPatients) from HospitalRoom where departmentId=:departmentId")
    int countTotalBedsInUseByDepartment(@Param("departmentId") UUID departmentId);
}
