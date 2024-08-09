package com.first_entity.firstEntity.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipe {
    @Id
    @GeneratedValue
    Integer idEquipe;
    String nomEquipe;
    Niveau niveau;

    @OneToOne
    @JoinColumn(name = "detailEquipe_id")
    DetailEquipe detailEquipe;

    @ManyToMany
    @JoinTable(
            name = "equipe_etudiant",
            joinColumns = {
                    @JoinColumn(name = "etudiant_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "equipe_id")
            }
    )
    List<Etudiant> etudiants;

}
