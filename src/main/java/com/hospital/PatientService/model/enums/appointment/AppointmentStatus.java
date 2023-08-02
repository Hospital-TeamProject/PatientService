package com.hospital.PatientService.model.enums.appointment;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AppointmentStatus {
    SCHEDULED("Scheduled"),
    CANCELED("CANCELED"),
    FINISHED("Finished");

    private String notation;

    AppointmentStatus(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }

    public AppointmentStatus valueOfNotation(String s) {
        for (AppointmentStatus as : values()) {
            if(as.notation.equals(s)) {
                return as;
            }
        }
        return null;
    }
}
