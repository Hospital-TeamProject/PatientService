package com.hospital.PatientService.repository.filtering.filter;

import com.hospital.PatientService.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class AppointmentFilter {
    private Patient patient;
    private Date date;
    private UUID departmentId;
}
