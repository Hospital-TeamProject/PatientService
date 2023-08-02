package com.hospital.PatientService.model.enums.testing;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Availability {
    CAN_MAKE_AN_APPOINTMENT("Can make an appointment"),
    TERM_IS_FULL("Term is full");

    private String notation;

    Availability(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }

    public Availability valueOfNotation(String s) {
        for(Availability a: values()) {
            if(a.notation.equals(s)) {
                return a;
            }
        }
        return null;
    }
}
