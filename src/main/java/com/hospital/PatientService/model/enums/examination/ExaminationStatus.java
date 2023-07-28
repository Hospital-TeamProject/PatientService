package com.hospital.PatientService.model.enums.examination;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExaminationStatus {
    SCHEDULED("Scheduled"),
    CANCELED("CANCELED"),
    IN_PROGRESS("In progress"),
    FINISHED("Finished");

    private String notation;

    ExaminationStatus(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }

    public static ExaminationStatus valueOfNotation(String s) {
        for (ExaminationStatus es : values()) {
            if(es.notation.equals(s)) {
                return es;
            }
        }
        return null;
    }
}
