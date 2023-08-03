package com.hospital.PatientService.repository;

import com.hospital.PatientService.model.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergyRepository extends JpaRepository<Allergy, Long> {
}
