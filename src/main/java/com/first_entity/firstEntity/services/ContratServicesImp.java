package com.first_entity.firstEntity.services;

import com.first_entity.firstEntity.entities.Contrat;
import com.first_entity.firstEntity.entities.Etudiant;
import com.first_entity.firstEntity.repositories.ContratRepository;
import com.first_entity.firstEntity.repositories.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContratServicesImp implements ContratServices {
    private final ContratRepository contratRepository;
    private final EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addOrUpdateContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public Contrat assignContratToEtudiant(Contrat contrat,String nom,String prenom) {
        Etudiant etudiant = etudiantRepository.findByNomEAndPrenomE(nom,prenom);
        if(contratRepository.countByArchiveIsFalseAndEtudiant(etudiant) < 5) {
            contrat.setEtudiant(etudiant);
            contratRepository.save(contrat);
        }
        return contrat;
    }
}
