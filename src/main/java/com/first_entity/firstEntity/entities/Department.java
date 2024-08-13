package com.first_entity.firstEntity.entities;

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
public class Department {
    @Id
    @GeneratedValue
    Integer idDepart;
    String nomDepart;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    List<Etudiant> etudiants;
}
