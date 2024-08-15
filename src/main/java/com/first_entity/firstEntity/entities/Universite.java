package com.first_entity.firstEntity.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Universite {
    @Id
    @GeneratedValue
    Integer idUniv;
    String nomUniv;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    List<Department> departments;
}
