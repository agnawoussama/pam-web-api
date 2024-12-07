package com.example.pam_web_api.pam_web_api.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.pam_web_api.pam_web_api.entities.Patient;
import com.example.pam_web_api.pam_web_api.services.PatientService;


@RestController
@RequestMapping("/api/patients")

public class PatientController {
    private final PatientService patientService;
    
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Cherche tous les patients
    @GetMapping
    public ResponseEntity<List<Patient>> obtenirTousLesPatients(){
        return new ResponseEntity<>(patientService.obtenirTousLesPatients(),HttpStatus.OK);
    }
    
    //Chercher un patient
    @GetMapping("/{id}")
    public ResponseEntity<Patient> obtenirPatient(@PathVariable("id") Long id) {
        return patientService.obtenirPatient(id)
            .map(patient -> ResponseEntity.ok(patient)) 
            .orElse(ResponseEntity.notFound().build()); 
    }

    //Ajouter un patient
    @PostMapping
    public Patient ajouterPatient(@RequestBody Patient patient) {
        return patientService.ajouterPatient(patient);
    }

    //Modifier un patient
    @PutMapping()
    public Patient majPatient(@RequestBody Patient patient) {    
        return patientService.majPatient(patient);
    }

    //Supprimer un patient
    @DeleteMapping("/{id}")
    public void supprimerPatient(@PathVariable("id") Long id) {
        patientService.supprimerPatient(id);
    }
}
