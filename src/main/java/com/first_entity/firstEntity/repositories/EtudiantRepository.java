package com.first_entity.firstEntity.repositories;

import com.first_entity.firstEntity.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
}