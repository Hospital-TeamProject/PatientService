package com.hospital.PatientService.repository.filtering.specification;

import com.hospital.PatientService.model.Patient;
import com.hospital.PatientService.model.ScheduledTesting;
import com.hospital.PatientService.repository.filtering.filter.ScheduledTestingFilter;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduledTestingSpecification implements Specification<ScheduledTesting> {
    private final ScheduledTestingFilter scheduledTestingFilter;

    public ScheduledTestingSpecification(ScheduledTestingFilter scheduledTestingFilter) {
        this.scheduledTestingFilter = scheduledTestingFilter;
    }

    @Override
    public Predicate toPredicate(Root<ScheduledTesting> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Path<Patient> patient = root.get("patient");
        Path<LocalDateTime> dateAndTime = root.get("dateAndTime");

        final List<Predicate> predicates = new ArrayList<>();
        if(scheduledTestingFilter.getPatient() != null) {
            predicates.add(criteriaBuilder.equal(patient, scheduledTestingFilter.getPatient()));
        }
        if(scheduledTestingFilter.getStartDate() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(dateAndTime, scheduledTestingFilter.getStartDate()));
        }
        if(scheduledTestingFilter.getEndDate() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(dateAndTime, scheduledTestingFilter.getEndDate()));
        }
        query.orderBy(criteriaBuilder.asc(dateAndTime));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
