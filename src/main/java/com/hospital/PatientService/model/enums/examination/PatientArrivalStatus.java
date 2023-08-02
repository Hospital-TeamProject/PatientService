package com.hospital.PatientService.model.enums.examination;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PatientArrivalStatus {
    DID_NOT_SHOW_UP("Didn't show up"),
    CANCELED("Cancelled"),
    WAITING("Waiting"),
    FINISHED("FINISHED"),
    ADMITTED("Admitted");

    private String notation;

    PatientArrivalStatus(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }

    public static PatientArrivalStatus valueOfNotation(String s) {
        for (PatientArrivalStatus pas : values()) {
            if(pas.notation.equals(s)) {
                return pas;
            }
        }
        return null;
    }
}
