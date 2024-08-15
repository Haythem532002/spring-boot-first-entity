package com.first_entity.firstEntity.services;

import com.first_entity.firstEntity.entities.Etudiant;

import java.util.List;

public interface EtudiantServices {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addOrUpdateEtudiant(Etudiant etudiant);
    List<Etudiant> addListOfEtudiant(List<Etudiant> etudiants);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);
    Etudiant assignEtudiantToDep(Integer idStudent,Integer idDep);
    Etudiant addAndAssignEtudiantToEquipeAndContrat(Etudiant etudiant, Integer idContrat, Integer idEquipe);
    List<Etudiant> getEtudiantsByDepartment(Integer idDepartment);
}
