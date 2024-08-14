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

        Department department = departmentRepository.findById(etudiant.getDepartment().getIdDepart()).orElse(null);
        etudiant.setDepartment(department);
        etudiantRepository.save(etudiant);

        Contrat contrat = contratRepository.findById(idContrat).orElseThrow(() -> new EntityNotFoundException("Contrat not found"));
        Equipe equipe = equipeRepository.findById(idEquipe).orElseThrow(() -> new EntityNotFoundException("Equipe not found"));

        contrat.setEtudiant(etudiant);
        contratRepository.save(contrat);


        List<Contrat> contrats = new ArrayList<>();
        contrats.add(contrat);
        etudiant.setContrats(contrats);


        equipe.getEtudiants().add(etudiant);

        List<Equipe> equipes = new ArrayList<>();
        equipes.add(equipe);
        etudiant.setEquipes(equipes);

        return etudiantRepository.save(etudiant);
    }
}
