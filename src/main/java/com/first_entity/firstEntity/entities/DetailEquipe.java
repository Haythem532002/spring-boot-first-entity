package com.first_entity.firstEntity.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailEquipe {
    @Id
    @GeneratedValue
    Integer idDetailEquipe;
    Integer salle;
    Integer thematique;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipe_id")
    Equipe equipe;
}
