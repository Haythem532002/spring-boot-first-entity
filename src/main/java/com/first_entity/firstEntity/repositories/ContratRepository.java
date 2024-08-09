package com.first_entity.firstEntity.repositories;

import com.first_entity.firstEntity.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
}