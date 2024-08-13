package com.first_entity.firstEntity.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipe {
    @Id
    @GeneratedValue
    Integer idEquipe;
    String nomEquipe;
    Niveau niveau;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "detailEquipe_id")
    DetailEquipe detailEquipe;

    @ManyToMany
    @JoinTable(
            name = "equipe_etudiant",
            joinColumns = {
                    @JoinColumn(name = "equipe_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "etudiant_id")
            }
    )
    List<Etudiant> etudiants;

}
