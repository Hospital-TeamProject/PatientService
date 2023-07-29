package com.hospital.PatientService.model.enums.medicalhistory;

public enum TreatmentResult {
    RECOVERED("Recovered"),
    DIED("Died"),
    LONG_TERM_CONSEQUENCES("Long-Term Consequences"),
    IN_PROGRESS("In progress");

    private String notation;

    TreatmentResult(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }

    public static TreatmentResult valueOfNotation(String s) {
        for (TreatmentResult tr : values()) {
            if(tr.notation.equals(s)) {
                return tr;
            }
        }
        return null;
    }
}
