package com.hospital.PatientService.repository.filter;

import com.hospital.PatientService.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduledTestingFilter {
    private Patient patient;
    private LocalDateTime date;
}
