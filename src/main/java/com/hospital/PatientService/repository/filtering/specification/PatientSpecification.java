package com.hospital.PatientService.repository.filtering.specification;

import com.hospital.PatientService.model.Patient;
import com.hospital.PatientService.repository.filtering.filter.PatientSearchFilter;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PatientSpecification implements Specification<Patient> {
    private final PatientSearchFilter patientFilter;

    public PatientSpecification(PatientSearchFilter patientFilter) {
        this.patientFilter = patientFilter;
    }

    @Override
    public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Path<UUID> patientId = root.get("patientId");
        Path<String> firstName = root.get("firstName");
        Path<String> lastName = root.get("lastName");
        Path<String> jmbg = root.get("jmbg");
        Path<Boolean> deleted = root.get("deleted");

        final List<Predicate> predicates = new ArrayList<>();
        if(patientFilter.getPatientId() != null) {
            predicates.add(criteriaBuilder.equal(patientId, patientFilter.getPatientId()));
        }
        if(patientFilter.getFirstName() != null) {
            predicates.add(criteriaBuilder.like(firstName, "%" + patientFilter.getFirstName() + "%"));
        }
        if(patientFilter.getLastName() != null) {
            predicates.add(criteriaBuilder.like(lastName, "%" + patientFilter.getLastName() + "%"));
        }
        if(patientFilter.getJmbg() != null) {
            predicates.add(criteriaBuilder.equal(jmbg, patientFilter.getJmbg()));
        }
        if(patientFilter.getIncludeDeleted() == null || !patientFilter.getIncludeDeleted()) {
            predicates.add(criteriaBuilder.isFalse(deleted));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
