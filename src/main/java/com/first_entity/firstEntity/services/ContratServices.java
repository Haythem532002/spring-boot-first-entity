package com.first_entity.firstEntity.services;

import com.first_entity.firstEntity.entities.Contrat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ContratServices {
    List<Contrat> retrieveAllContrats();
    Contrat addOrUpdateContrat(Contrat contrat);
    Contrat retrieveContrat(Integer idContrat);
    void removeContrat(Integer idContrat);
    Contrat assignContratToEtudiant(Contrat contrat,String nom,String prenom);
    Integer nbContratsValides(LocalDate startDate, LocalDate endDate);
}
