package com.hospital.PatientService.repository.filtering.specification;

import com.hospital.PatientService.model.HospitalRoom;
import com.hospital.PatientService.model.Hospitalization;
import com.hospital.PatientService.model.Patient;
import com.hospital.PatientService.repository.filtering.filter.HospitalizedPatientSearchFilter;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class HospitalizedPatientSpecification implements Specification<Hospitalization> {

    private final HospitalizedPatientSearchFilter hospitalizedPatientFilter;

    public HospitalizedPatientSpecification(HospitalizedPatientSearchFilter hospitalizedPatientFilter) {
        this.hospitalizedPatientFilter = hospitalizedPatientFilter;
    }

    @Override
    public Predicate toPredicate(Root<Hospitalization> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Join<Patient, Hospitalization> patientJoins = root.join("patient");
        Join<HospitalRoom,Hospitalization> roomJoin = root.join("hospitalRoom");
        Path<UUID> patientId = patientJoins.get("id");
        Path<UUID> departmentId = roomJoin.get("departmentId");
        Path<String> firstName = patientJoins.get("firstName");
        Path<String> lastName = patientJoins.get("lastName");
        Path<String> jmbg = patientJoins.get("jmbg");
        Path<Date> dischargeDate = root.get("dischargeDate");

        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.isNull(dischargeDate));
        if(hospitalizedPatientFilter.getPatientId() != null) {
            predicates.add(criteriaBuilder.equal(patientId, hospitalizedPatientFilter.getPatientId()));
        }
        if(hospitalizedPatientFilter.getDepartmentId() != null) {
            predicates.add(criteriaBuilder.equal(departmentId, hospitalizedPatientFilter.getDepartmentId()));
        }
        if(hospitalizedPatientFilter.getFirstName() != null) {
            predicates.add(criteriaBuilder.like(firstName, "%" + hospitalizedPatientFilter.getFirstName() + "%"));
        }
        if(hospitalizedPatientFilter.getLastName() != null) {
            predicates.add(criteriaBuilder.like(lastName, "%" + hospitalizedPatientFilter.getLastName() + "%"));
        }
        if(hospitalizedPatientFilter.getJmbg() != null) {
            predicates.add(criteriaBuilder.equal(jmbg, hospitalizedPatientFilter.getJmbg()));
        }
        if(hospitalizedPatientFilter.getDepartmentIds() != null) {
            predicates.add(departmentId.in(hospitalizedPatientFilter.getDepartmentIds()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
