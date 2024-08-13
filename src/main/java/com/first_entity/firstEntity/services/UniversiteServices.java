package com.first_entity.firstEntity.services;

import com.first_entity.firstEntity.entities.Universite;

import java.util.List;

public interface UniversiteServices {
    List<Universite> retrieveAllUniversities();
    Universite addOrUpdateUniversite(Universite universite);
    Universite retrieveUniversite(Integer idUniversite);
    void removeUniversite(Integer idUniversite);
    void assignUniversiteToDepartment(Integer idUniversite,Integer idDep);
}
