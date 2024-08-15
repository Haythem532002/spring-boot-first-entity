package com.first_entity.firstEntity.controllers;


import com.first_entity.firstEntity.entities.Etudiant;
import com.first_entity.firstEntity.services.EtudiantServicesImp;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    private final EtudiantServicesImp etudiantServicesImp;

    @PostMapping("/add")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantServicesImp.addOrUpdateEtudiant(etudiant);
    }

    @PutMapping("/update")
    Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantServicesImp.addOrUpdateEtudiant(etudiant);
    }

    @GetMapping("/get/{id}")
    Etudiant getEtudiant(@PathVariable("id") Integer idEtudiant) {
        return etudiantServicesImp.retrieveEtudiant(idEtudiant);
    }

    @GetMapping("/all")
    List<Etudiant> getAllEtudiant() {
        return etudiantServicesImp.retrieveAllEtudiants();
    }


    @DeleteMapping("/delete/{id}")
    void deleteEtudiant(
            @PathVariable("id") Integer idEtudiant
    ) {
        etudiantServicesImp.removeEtudiant(idEtudiant);
    }

    @Operation(description = "This method assign Student to a Department")
    @PutMapping("/assign/{id-etudiant}/{id-dep}")
    public Etudiant assignEtudiantToDep(
            @PathVariable("id-etudiant") Integer idEtudiant,
            @PathVariable("id-dep")Integer idDep
    ) {
        return etudiantServicesImp.assignEtudiantToDep(idEtudiant,idDep);
    }

    @Operation(description = "This method assing Student to a contrat and equipe")
    @PutMapping("/addAndAssign/{id-contrat}/{id-equipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContrat(
            @RequestBody Etudiant etudiant,
            @PathVariable("id-contrat") Integer idContrat,
            @PathVariable("id-equipe") Integer idEquipe
    ) {
        return etudiantServicesImp.addAndAssignEtudiantToEquipeAndContrat(etudiant, idContrat, idEquipe);
    }

    @Operation(description = "This method get all students that beong to the same department")
    @GetMapping("/getEtudiantsByDepartment/{id-department}")
    public List<Etudiant> getEtudiantsByDepartment(
            @PathVariable("id-department") Integer idDepartment
    ) {
        return etudiantServicesImp.getEtudiantsByDepartment(idDepartment);
    }

}
