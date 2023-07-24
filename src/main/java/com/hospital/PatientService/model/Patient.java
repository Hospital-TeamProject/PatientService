package com.hospital.PatientService.model;

import com.hospital.PatientService.model.enums.patient.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String jmbg;
    @Column(nullable = false, unique = true)
    private UUID patientId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private Date date;
    @Column
    private String address;
    @Column
    private String placeOfLiving;
    @Column
    private String phoneNumber;
    @Column
    private String email;
    @Column
    private Boolean deleted = false;
    @Column
    private Boolean immunized = false;
}
