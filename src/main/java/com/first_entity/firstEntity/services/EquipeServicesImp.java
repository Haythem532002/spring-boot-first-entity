package com.first_entity.firstEntity.services;

import com.first_entity.firstEntity.entities.Equipe;
import com.first_entity.firstEntity.repositories.EquipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipeServicesImp implements EquipeServices{
    private final EquipeRepository equipeRepository;

    @Override
    public List<Equipe> retieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addOrUpdateEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public void removeEquipe(Integer idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }
}
