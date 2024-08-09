package com.first_entity.firstEntity.repositories;

import com.first_entity.firstEntity.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}