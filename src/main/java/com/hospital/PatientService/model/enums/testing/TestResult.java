package com.hospital.PatientService.model.enums.testing;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TestResult {
    UNPROCCESED("Unproccessed"),
    POSITIVE("Positive"),
    NEGATIVE("Negative");

    private String notation;

    TestResult(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }

    public static TestResult valueOfNotation(String s) {
        for(TestResult tr : values()) {
            if(tr.notation.equals(s)){
                return tr;
            }
        }
        return null;
    }
}
