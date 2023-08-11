package com.hospital.PatientService.repository.filtering.specification;

import com.hospital.PatientService.model.Patient;
import com.hospital.PatientService.model.PatientCondition;
import com.hospital.PatientService.repository.filtering.filter.PatientConditionFilter;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PatientConditionSpecification implements Specification<PatientCondition> {
    private final PatientConditionFilter patientConditionFilter;

    public PatientConditionSpecification(PatientConditionFilter patientConditionFilter) {
        this.patientConditionFilter = patientConditionFilter;
    }

    @Override
    public Predicate toPredicate(Root<PatientCondition> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Join<Patient, PatientCondition> patientJoin = root.join("patient");
        Path<UUID> patientId = patientJoin.get("patientId");
        Path<Date> collectedInfoDate = root.get("collectedInfoDate");

        final List<Predicate> predicates = new ArrayList<>();
        if(patientConditionFilter.getPatientId() != null) {
            predicates.add(criteriaBuilder.equal(patientId, patientConditionFilter.getPatientId()));
        }
        if(patientConditionFilter.getDateFrom() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(collectedInfoDate, patientConditionFilter.getDateFrom()));
        }
        if(patientConditionFilter.getDateTo() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(collectedInfoDate, patientConditionFilter.getDateTo()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
