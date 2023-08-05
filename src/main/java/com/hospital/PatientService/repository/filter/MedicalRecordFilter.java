package com.hospital.PatientService.repository.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class MedicalRecordFilter {
    private UUID patientId;
    private Date dateFrom;
    private Date dateTo;
}
