package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.AvailableTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AvailableTermRepository extends JpaRepository<AvailableTerm, Long> {
    @Query(value = "select a from AvailableTerm a where a.dateAndTime>:startDate and a.dateAndTime<:endDate and a.departmentId=:departmentId")
    List<AvailableTerm> findAvailableTermsBetweenStartDateAndEndDateAndDepartmentId(@Param("startDate") Date startDate,
                                                                                    @Param("endDate") Date endDate,
                                                                                    @Param("departmentId") UUID departmentId);
    @Query(value = "select a from AvailableTerm a where a.dateAndTime between :startDate and :endDate")
    List<AvailableTerm> findAvailableTermsBetweenStartDateAndEndDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "select a from AvailableTerm a where a.dateAndTime=:dateAndTime and a.departmentId=:departmentId")
    Optional<AvailableTerm> findByDepartmentIdAndDateAndTime(@Param("departmentId") UUID departmentId, @Param("dateAndTime") Date dateAndTime);
}
