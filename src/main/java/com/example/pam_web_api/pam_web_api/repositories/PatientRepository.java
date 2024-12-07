package com.example.pam_web_api.pam_web_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pam_web_api.pam_web_api.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long>{

}
