package com.first_entity.firstEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
}
