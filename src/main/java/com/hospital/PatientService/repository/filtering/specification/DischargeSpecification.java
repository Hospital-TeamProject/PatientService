package com.hospital.PatientService.repository.filtering.specification;

import com.hospital.PatientService.model.DischargeList;
import com.hospital.PatientService.model.Patient;
import com.hospital.PatientService.repository.filtering.filter.DischargeFilter;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class DischargeSpecification implements Specification<DischargeList> {
    private final DischargeFilter dischargeFilter;

    public DischargeSpecification(DischargeFilter dischargeFilter) {
        this.dischargeFilter = dischargeFilter;
    }

    @Override
    public Predicate toPredicate(Root<DischargeList> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Join<Patient, DischargeList> patientJoin = root.join("patient");
        Path<UUID> patientId = patientJoin.get("patientId");
        Path<Date> date = root.get("date");

        final List<Predicate> predicates = new ArrayList<>();
            if(dischargeFilter.getPatientId() != null){
                predicates.add(criteriaBuilder.equal(patientId, dischargeFilter.getPatientId()));
            }
            if(dischargeFilter.getDateFrom() != null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(date, dischargeFilter.getDateFrom()));
            }
            if(dischargeFilter.getDateTo() != null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(date, dischargeFilter.getDateTo()));
            }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
