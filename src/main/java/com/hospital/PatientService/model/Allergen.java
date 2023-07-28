package com.hospital.PatientService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Allergen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "allergen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Allergy> allergies;
}
