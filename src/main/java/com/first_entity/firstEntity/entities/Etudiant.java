package com.first_entity.firstEntity.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor@Entity
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_id")
    @JsonBackReference
    Department department;

    @ManyToMany(mappedBy = "etudiants",cascade = CascadeType.PERSIST)
    @JsonIgnore
    List<Equipe> equipes;
}
