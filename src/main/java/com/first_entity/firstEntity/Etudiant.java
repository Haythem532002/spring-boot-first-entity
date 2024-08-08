package com.first_entity.firstEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant {
    @Id
    @GeneratedValue
    Integer idEtudiant;
    String nomE;
    String prenomE;
    Option option;

    @OneToMany(mappedBy = "etudiant")
    @JsonManagedReference
    List<Contrat> contrats;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    @JsonBackReference
    Departement departement;

    @ManyToMany(mappedBy = "etudiants")
    List<Equipe> equipes;
}
