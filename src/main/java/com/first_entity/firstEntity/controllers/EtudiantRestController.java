package com.first_entity.firstEntity.controllers;


import com.first_entity.firstEntity.entities.Etudiant;
import com.first_entity.firstEntity.services.EtudiantServicesImp;
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
}
