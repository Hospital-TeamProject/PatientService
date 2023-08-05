package com.hospital.PatientService.repository.filtering.filter;

import com.hospital.PatientService.model.HealthRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class MedicalExaminationFilter {
    private HealthRecord healthRecord;
    private Date startDate;
    private Date endDate;
}
