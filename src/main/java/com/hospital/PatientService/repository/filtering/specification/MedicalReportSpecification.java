package com.hospital.PatientService.repository.filtering.specification;

import com.hospital.PatientService.model.MedicalReport;
import com.hospital.PatientService.model.Patient;
import com.hospital.PatientService.repository.filtering.filter.MedicalReportFilter;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MedicalReportSpecification implements Specification<MedicalReport> {
    private final MedicalReportFilter medicalReportFilter;

    public MedicalReportSpecification(MedicalReportFilter medicalReportFilter) {
        this.medicalReportFilter = medicalReportFilter;
    }

    @Override
    public Predicate toPredicate(Root<MedicalReport> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Join<Patient, MedicalReport> patientJoin = root.join("patient");
        Path<UUID> patientId = patientJoin.get("patientId");
        Path<Date> date = root.get("date");
        Path<Boolean> isDeleted = root.get("isDeleted");

        final List<Predicate> predicates = new ArrayList<>();
        if(medicalReportFilter.getPatientId() != null) {
            predicates.add(criteriaBuilder.equal(patientId,medicalReportFilter.getPatientId()));
        }
        if(medicalReportFilter.getDateFrom() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(date, medicalReportFilter.getDateFrom()));
        }
        if(medicalReportFilter.getDateTo() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(date, medicalReportFilter.getDateTo()));
        }
        predicates.add(criteriaBuilder.equal(isDeleted,false));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));


    }
}
