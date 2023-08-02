package com.hospital.PatientService.model.enums.healthrecord;

public enum RHFactor {
    PLUS("+"),
    MINUS("-");

    String notation;

    RHFactor(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }

    private static RHFactor valueOfNotation(String notation) {
        for(RHFactor rh : values()) {
            if(rh.notation.equals(notation)) {
                return rh;
            }
        }
        return null;
    }
}
