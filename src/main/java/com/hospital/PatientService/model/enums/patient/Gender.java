package com.hospital.PatientService.model.enums.patient;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String notation;

    Gender(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }

    public static Gender valueOfNotation(String s) {
        for(Gender g : values()) {
            if(g.notation.equals(s)) {
                return g;
            }
        }
        return null;
    }
}
