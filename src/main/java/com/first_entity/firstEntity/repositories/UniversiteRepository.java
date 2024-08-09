package com.first_entity.firstEntity.repositories;

import com.first_entity.firstEntity.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UniversiteRepository extends JpaRepository<Universite, Integer> {
}