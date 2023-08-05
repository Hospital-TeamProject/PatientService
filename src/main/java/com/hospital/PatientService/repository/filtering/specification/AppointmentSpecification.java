package com.hospital.PatientService.repository.filtering.specification;

import com.hospital.PatientService.model.Appointment;
import com.hospital.PatientService.model.Patient;
import com.hospital.PatientService.repository.filtering.filter.AppointmentFilter;
import jakarta.persistence.criteria.*;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.*;

public class AppointmentSpecification implements Specification<Appointment> {
    private final AppointmentFilter appointmentFilter;

    public AppointmentSpecification(AppointmentFilter appointmentFilter) {
        this.appointmentFilter = appointmentFilter;
    }

    @Override
    public Predicate toPredicate(Root<Appointment> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Path<Patient> patient = root.get("patient");
        Path<Date> appointmentDate = root.get("appointmentDate");
        Path<UUID> departmentId = root.get("departmentId");
        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(departmentId, appointmentFilter.getDepartmentId()));
        if(appointmentFilter.getPatient() != null){
            predicates.add(criteriaBuilder.equal(patient, appointmentFilter.getPatient()));
        }
        if(appointmentFilter.getDate() != null){
            Date startDate = DateUtils.truncate(appointmentFilter.getDate(), Calendar.DAY_OF_MONTH);
            Date endDate = DateUtils.addDays(startDate, 1);
            predicates.add(criteriaBuilder.between(appointmentDate, startDate, endDate));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
