package com.first_entity.firstEntity.services;


import com.first_entity.firstEntity.entities.Departement;
import com.first_entity.firstEntity.repositories.DepartementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServicesImp implements DepartmentServices{
    private final DepartementRepository departementRepository;

    @Override
    public List<Departement> retrieveAllDepartments() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addOrUpdateDepartment(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public Departement retrieveDepartment(Integer idDepartement) {
        return departementRepository.findById(idDepartement).orElse(null);
    }

    @Override
    public void removeDepartment(Integer idDepartement) {
        departementRepository.deleteById(idDepartement);
    }
}
