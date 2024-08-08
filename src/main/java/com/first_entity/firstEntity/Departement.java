package com.first_entity.firstEntity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Departement {
    @Id
    @GeneratedValue
    Integer idDepart;
    String nomDepart;

    @OneToMany(mappedBy = "departement")
    @JsonManagedReference
    List<Etudiant> etudiants;
}
