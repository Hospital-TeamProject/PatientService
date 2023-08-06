package com.hospital.PatientService.repository.filtering.specification;

import com.hospital.PatientService.model.Diagnosis;
import com.hospital.PatientService.model.HealthRecord;
import com.hospital.PatientService.model.MedicalHistory;
import com.hospital.PatientService.repository.filtering.filter.MedicalHistoryFilter;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class MedicalHistorySpecification implements Specification<MedicalHistory> {

    private final MedicalHistoryFilter medicalHistoryFilter;

    public MedicalHistorySpecification(MedicalHistoryFilter medicalHistoryFilter) {
        this.medicalHistoryFilter = medicalHistoryFilter;
    }

    @Override
    public Predicate toPredicate(Root<MedicalHistory> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Join<Diagnosis, MedicalHistory> diagnosisJoin = root.join("diagnosis");
        Path<HealthRecord> healthRecord = root.get("healthRecord");
        Path<String> diagnosisCode = diagnosisJoin.get("code");

        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(healthRecord, medicalHistoryFilter.getHealthRecord()));
        if(medicalHistoryFilter.getDiagnosisCode() != null && !medicalHistoryFilter.getDiagnosisCode().trim().isEmpty()) {
            predicates.add(criteriaBuilder.equal(diagnosisCode, medicalHistoryFilter.getDiagnosisCode()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
