package com.hospital.PatientService.repository.filtering.specification;

import com.hospital.PatientService.model.ScheduledMedExamination;
import com.hospital.PatientService.repository.filtering.filter.ScheduledMedExaminationFilter;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ScheduledMedExaminationSpecification implements Specification<ScheduledMedExamination> {
    private final ScheduledMedExaminationFilter scheduledMedExaminationFilter;

    public ScheduledMedExaminationSpecification(ScheduledMedExaminationFilter scheduledMedExaminationFilter) {
        this.scheduledMedExaminationFilter = scheduledMedExaminationFilter;
    }

    @Override
    public Predicate toPredicate(Root<ScheduledMedExamination> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Path<UUID> doctorId = root.get("doctorId");
        Path<Date> appointmentDate = root.get("appointmentDate");

        final List<Predicate> predicates = new ArrayList<>();

        if(scheduledMedExaminationFilter.getEmployeeId() != null) {
            predicates.add(criteriaBuilder.equal(doctorId, scheduledMedExaminationFilter.getEmployeeId()));
        }
        if(scheduledMedExaminationFilter.getStartDate() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(appointmentDate, scheduledMedExaminationFilter.getStartDate()));
        }
        if(scheduledMedExaminationFilter.getEndDate() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(appointmentDate, scheduledMedExaminationFilter.getEndDate()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
