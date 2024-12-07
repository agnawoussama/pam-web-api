package com.example.pam_web_api.pam_web_api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dentistes")
@Getter
@Setter
/**
 * Dentiste
 */
public class Dentiste{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String specialite;
}