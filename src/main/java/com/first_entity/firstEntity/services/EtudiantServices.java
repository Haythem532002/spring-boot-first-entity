package com.first_entity.firstEntity.services;

import com.first_entity.firstEntity.entities.Etudiant;

import java.util.List;

public interface EtudiantServices {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addOrUpdateEtudiant(Etudiant etudiant);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);
}
