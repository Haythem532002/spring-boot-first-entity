package com.first_entity.firstEntity.repositories;

import com.first_entity.firstEntity.entities.Contrat;
import com.first_entity.firstEntity.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    Integer countByArchiveIsFalseAndEtudiant(Etudiant etudiant);
}