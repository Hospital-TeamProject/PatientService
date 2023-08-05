package com.hospital.PatientService.repository.filtering.specification;

import com.hospital.PatientService.model.Appointment;
import com.hospital.PatientService.repository.filtering.filter.AppointmentFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AppointmentSpecification implements Specification<Appointment> {
    private final AppointmentFilter appointmentFilter;

    public AppointmentSpecification(AppointmentFilter appointmentFilter) {
        this.appointmentFilter = appointmentFilter;
    }

    @Override
    public Predicate toPredicate(Root<Appointment> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
