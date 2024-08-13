package com.first_entity.firstEntity.controllers;

import com.first_entity.firstEntity.entities.Universite;
import com.first_entity.firstEntity.services.UniversiteServicesImp;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
    private final UniversiteServicesImp universiteServicesImp;

    @PostMapping("/add")
    Universite addUniversite(@RequestBody Universite universite) {
        return universiteServicesImp.addOrUpdateUniversite(universite);
    }

    @PutMapping("/update")
    Universite updateUniversite(@RequestBody Universite universite){
        return universiteServicesImp.addOrUpdateUniversite(universite);
    }

    @GetMapping("/get/{id}")
    Universite getUniversite(
            @PathVariable("id") Integer idUniversite
    ) {
        return universiteServicesImp.retrieveUniversite(idUniversite);
    }

    @GetMapping("/all")
    List<Universite> getAllUniversite() {
        return universiteServicesImp.retrieveAllUniversities();
    }

    @DeleteMapping("/delete/{id}")
    void deleteUniversite(@PathVariable("id") Integer idUniversite) {
        universiteServicesImp.removeUniversite(idUniversite);
    }
    @Operation(description = "This method assign Universite to Department")
    @PutMapping("/assign/{id-universite}/{id-dep}")
    public void assignUniversiteToDepartment(
            @PathVariable("id-universite") Integer idUniversite,
            @PathVariable("id-dep") Integer idDep
    ) {
        universiteServicesImp.assignUniversiteToDepartment(idUniversite, idDep);
    }
}
