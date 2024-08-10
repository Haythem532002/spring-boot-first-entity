package com.first_entity.firstEntity.controllers;

import com.first_entity.firstEntity.entities.Universite;
import com.first_entity.firstEntity.services.UniversiteServicesImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/university")
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

}
