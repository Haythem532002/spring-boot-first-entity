package com.first_entity.firstEntity.services;

import com.first_entity.firstEntity.entities.Equipe;

import java.util.List;

public interface EquipeServices {
    List<Equipe> retieveAllEquipes();
    Equipe addOrUpdateEquipe(Equipe equipe);
    Equipe retrieveEquipe(Integer idEquipe);
    void removeEquipe(Integer idEquipe);
}
