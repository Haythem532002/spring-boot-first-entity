package com.first_entity.firstEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
}
