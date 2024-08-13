package com.first_entity.firstEntity.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat {
    @Id
    @GeneratedValue
    Integer IdContrat;
    LocalDate dateDebutContrat;
    LocalDate dateFinContrat;
    Specialite specialite;
    boolean archive;
    Integer montantContrat;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    @JsonBackReference
    Etudiant etudiant;
}
