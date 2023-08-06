package com.hospital.PatientService.repository.filtering.specification;

import com.hospital.PatientService.model.HealthRecord;
import com.hospital.PatientService.model.MedicalExamination;
import com.hospital.PatientService.repository.filtering.filter.MedicalExaminationFilter;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicalExaminationSpecification implements Specification<MedicalExamination> {
    private final MedicalExaminationFilter medicalExaminationFilter;

    public MedicalExaminationSpecification(MedicalExaminationFilter medicalExaminationFilter) {
        this.medicalExaminationFilter = medicalExaminationFilter;
    }

    @Override
    public Predicate toPredicate(Root<MedicalExamination> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Path<HealthRecord> healthRecord = root.get("healthRecord");
        Path<Date> date = root.get("date");

        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(healthRecord, medicalExaminationFilter.getHealthRecord()));
        if(medicalExaminationFilter.getStartDate() != null) {
            predicates.add(criteriaBuilder.between(date, medicalExaminationFilter.getStartDate(), medicalExaminationFilter.getEndDate()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
