package com.first_entity.firstEntity.controllers;

import com.first_entity.firstEntity.entities.Contrat;
import com.first_entity.firstEntity.services.ContratServicesImp;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contrat")
public class ContratRestController {
    private final ContratServicesImp contratServicesImp;

    @PostMapping("/add")
    Contrat addContrat(
            @RequestBody Contrat contrat
    ) {
        return contratServicesImp.addOrUpdateContrat(contrat);
    }
    @PutMapping("/update")
    Contrat updateContrat(
            @RequestBody Contrat contrat
    ) {
        return contratServicesImp.addOrUpdateContrat(contrat);
    }

    @GetMapping("/get/{id}")
    Contrat getContrat(
            @PathVariable("id") Integer idContrat
    ) {
        return contratServicesImp.retrieveContrat(idContrat);
    }

    @GetMapping("/all")
    List<Contrat> getAllContrat() {
        return contratServicesImp.retrieveAllContrats();
    }
    @DeleteMapping("/delete/{id}")
    void deleteContrat(
            @PathVariable("id") Integer idContrat
    ) {
        contratServicesImp.removeContrat(idContrat);
    }

    @Operation(description = "This method assign Contrat to Etudiant")
    @PutMapping("/assign/{nom}/{prenom}")
    Contrat assignContratToEtudiant(
            @RequestBody Contrat contrat,
            @PathVariable("nom") String Nom,
            @PathVariable("prenom") String Prenom
    ) {
        return contratServicesImp.assignContratToEtudiant(contrat, Nom,Prenom);
    }
}
