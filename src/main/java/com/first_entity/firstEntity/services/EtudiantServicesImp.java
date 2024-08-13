package com.first_entity.firstEntity.services;


import com.first_entity.firstEntity.entities.*;
import com.first_entity.firstEntity.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantServicesImp implements EtudiantServices{
    private final EtudiantRepository etudiantRepository;
    private final DepartmentRepository departmentRepository;
    private final ContratRepository contratRepository;
    private final EquipeRepository equipeRepository;


    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addOrUpdateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> addListOfEtudiant(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElse(null);
        if(etudiant!=null) {
            for(Contrat contrat:etudiant.getContrats()) {
                contrat.setEtudiant(null);
            }
            for(Equipe equipe:etudiant.getEquipes()) {
                equipe.setEtudiants(null);
            }
        }
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant assignEtudiantToDep(Integer idStudent, Integer idDep) {
        Etudiant etudiant = etudiantRepository.findById(idStudent).orElse(null);
        Department department = departmentRepository.findById(idDep).orElse(null);
        etudiant.setDepartment(department);
        return etudiantRepository.save(etudiant);
    }

    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContrat(Etudiant etudiant, Integer idContrat, Integer idEquipe) {
        // Save the etudiant first
        etudiantRepository.save(etudiant);

        // Fetch the contrat and equipe entities
        Contrat contrat = contratRepository.findById(idContrat).orElseThrow(() -> new EntityNotFoundException("Contrat not found"));
        Equipe equipe = equipeRepository.findById(idEquipe).orElseThrow(() -> new EntityNotFoundException("Equipe not found"));

        // Associate the contrat with the etudiant
        contrat.setEtudiant(etudiant);
        contratRepository.save(contrat);

        // Add the contrat to the etudiant's contrats list

        List<Contrat> contrats = new ArrayList<>();
        contrats.add(contrat);
        etudiant.setContrats(contrats);


        // Associate the equipe with the etudiant
        equipe.getEtudiants().add(etudiant);
//        equipeRepository.save(equipe);

        // Add the equipe to the etudiant's equipes list
        List<Equipe> equipes = new ArrayList<>();
        equipes.add(equipe);
        etudiant.setEquipes(equipes);

        // Save the etudiant again to persist the relationship
        return etudiantRepository.save(etudiant);
    }
}
