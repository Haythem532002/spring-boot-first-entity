package com.first_entity.firstEntity.controllers;

import com.first_entity.firstEntity.entities.Equipe;
import com.first_entity.firstEntity.services.EquipeServicesImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipe")
public class EquipeRestController {
    private final EquipeServicesImp equipeServicesImp;

    @PostMapping("/add")
    Equipe addEquipe (@RequestBody Equipe equipe) {
        return equipeServicesImp.addOrUpdateEquipe(equipe);
    }

    @PutMapping("/update")
    Equipe updateEquipe(@RequestBody Equipe equipe) {
        return equipeServicesImp.addOrUpdateEquipe(equipe);
    }

    @GetMapping("/get/{id}")
    Equipe getEquipe(
            @PathVariable("id") Integer idEquipe
    ) {
        return equipeServicesImp.retrieveEquipe(idEquipe);
    }
    @GetMapping("/all")
    List<Equipe> getAllEquipe() {
        return equipeServicesImp.retrieveAllEquipes();
    }
    @DeleteMapping("/delete/{id}")
    void deleteEquipe(
            @PathVariable("id") Integer idEquipe
    ) {
        equipeServicesImp.removeEquipe(idEquipe);
    }
}
