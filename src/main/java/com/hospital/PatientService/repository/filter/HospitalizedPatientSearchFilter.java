package com.hospital.PatientService.repository.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class HospitalizedPatientSearchFilter {
    private UUID patientId;
    private String firstName;
    private String lastName;
    private String jmbg;
    private UUID departmentId;
    private List<UUID> departmentIds;
}
