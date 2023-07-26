package com.hospital.PatientService.model.enums.healthrecord;

public enum BloodType {

    A,B,AB,O;

    private static BloodType findByName(String name) {
        for(BloodType bt : values()) {
            if(bt.name().equals(name)) {
                return bt;
            }
        }
        return null;
    }

}
