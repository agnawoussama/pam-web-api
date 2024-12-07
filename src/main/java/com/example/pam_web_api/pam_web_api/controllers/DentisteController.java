package com.example.pam_web_api.pam_web_api.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.pam_web_api.pam_web_api.entities.Dentiste;
import com.example.pam_web_api.pam_web_api.services.DentisteService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/dentistes")

public class DentisteController {
    private final DentisteService dentisteService;

    public DentisteController(DentisteService dentisteService) {
        this.dentisteService = dentisteService;
    }

    // Cherche tous les dentistes
    @GetMapping
    public ResponseEntity<List<Dentiste>> obtenirTousLesDentistes(){
        return new ResponseEntity<>(dentisteService.obtenirTousLesDentistes(),HttpStatus.OK);
    }    

    //Cherche un dentiste
    @GetMapping("/{id}")
    public ResponseEntity<Dentiste> obtenirDentiste(@PathVariable("id") Long id) {
        return dentisteService.obtenirDentiste(id)
            .map(dentiste -> ResponseEntity.ok(dentiste)) 
            .orElse(ResponseEntity.notFound().build()); 
    }

    //Ajouter un dentiste
    @PostMapping
    public Dentiste ajouterDentiste(@RequestBody Dentiste dentiste) {
        return dentisteService.ajouterDentiste(dentiste);
    }

    //Modifier info d'un denstiste
    @PutMapping()
    public Dentiste majDentiste(@RequestBody Dentiste dentiste) {    
        return dentisteService.majDentiste(dentiste);
    }

    //Supprimer dentiste
    @DeleteMapping("/{id}")
    public void supprimerDentiste(@PathVariable Long id) {
        dentisteService.supprimerDentiste(id);
    }
}
