package com.first_entity.firstEntity.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailEquipe {
    @Id
    @GeneratedValue
    Integer idDetailEquipe;
    Integer salle;
    Integer thematique;

    @OneToOne
    @JoinColumn(name = "equipe_id")
    Equipe equipe;
}
