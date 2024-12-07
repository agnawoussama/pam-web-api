
package com.example.pam_web_api.pam_web_api.services;

import com.example.pam_web_api.pam_web_api.entities.Patient;
import com.example.pam_web_api.pam_web_api.repositories.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> obtenirTousLesPatients() {
        return patientRepository.findAll();
    }

    public Patient ajouterPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void supprimerPatient(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient majPatient(Patient patient) {
        Patient nvPatient = patientRepository.getReferenceById(patient.getId());
        nvPatient.setNom(patient.getNom());
        nvPatient.setPrenom(patient.getPrenom());
        nvPatient.setAge(patient.getAge());
        nvPatient.setDerniereVisite(patient.getDerniereVisite());
        return patientRepository.save(nvPatient);
    }

    public Optional<Patient> obtenirPatient(Long id) {
        return patientRepository.findById(id);
    }
}