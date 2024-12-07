package com.example.pam_web_api.pam_web_api.services;

import com.example.pam_web_api.pam_web_api.entities.Dentiste;
import com.example.pam_web_api.pam_web_api.repositories.DentisteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DentisteService {
    private final DentisteRepository dentisteRepository;

    public DentisteService(DentisteRepository dentisteRepository) {
        this.dentisteRepository = dentisteRepository;
    }

    public List<Dentiste> obtenirTousLesDentistes() {
        return dentisteRepository.findAll();
    }

    public Dentiste ajouterDentiste(Dentiste dentiste) {
        return dentisteRepository.save(dentiste);
    }

    public void supprimerDentiste(Long id) {
        dentisteRepository.deleteById(id);
    }

    public Dentiste majDentiste(Dentiste dentiste) {
        Dentiste nvDentiste = dentisteRepository.getReferenceById(dentiste.getId());
        nvDentiste.setNom(dentiste.getNom());
        nvDentiste.setPrenom(dentiste.getPrenom());
        nvDentiste.setSpecialite(dentiste.getSpecialite());
        return dentisteRepository.save(nvDentiste);
    }

    public Optional<Dentiste> obtenirDentiste(Long id) {
        return dentisteRepository.findById(id);
    }
}