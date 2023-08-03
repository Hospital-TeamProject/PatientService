package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Allergen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergenRepository extends JpaRepository<Allergen, Long> {
}
