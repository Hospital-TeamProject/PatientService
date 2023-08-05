package com.hospital.PatientService.repository.filtering.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;
@Getter
@AllArgsConstructor
public class DischargeFilter {
    private UUID patientId;
    private Date dateFrom;
    private Date dateTo;
}
