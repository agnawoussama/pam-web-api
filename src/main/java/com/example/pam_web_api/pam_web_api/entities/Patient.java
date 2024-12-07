package com.example.pam_web_api.pam_web_api.entities;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patients")
@JsonIdentityInfo(
    scope = Patient.class,
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private int age;
    private String derniereVisite;

}
