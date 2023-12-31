package com.hospital.PatientService.repository.filtering.filter;

import com.hospital.PatientService.model.HealthRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MedicalHistoryFilter {
    private HealthRecord healthRecord;
    private String diagnosisCode;
}
