package com.first_entity.firstEntity.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat {
    @Id
    @GeneratedValue
    Integer IdContrat;
    LocalDateTime dateDebutContrat;
    LocalDateTime dateFinContrat;
    Specialite specialite;
    boolean archive;
    Integer montantContrat;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    @JsonBackReference
    Etudiant etudiant;
}
