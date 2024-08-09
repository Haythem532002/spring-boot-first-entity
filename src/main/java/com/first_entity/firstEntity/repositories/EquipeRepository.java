package com.first_entity.firstEntity.repositories;

import com.first_entity.firstEntity.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
}