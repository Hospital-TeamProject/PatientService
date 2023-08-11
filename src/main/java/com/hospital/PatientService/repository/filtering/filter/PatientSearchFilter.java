package com.hospital.PatientService.repository.filtering.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class PatientSearchFilter {
    private UUID patientId;
    private String firstName;
    private String lastName;
    private String jmbg;
    private Boolean includeDeleted;
}
