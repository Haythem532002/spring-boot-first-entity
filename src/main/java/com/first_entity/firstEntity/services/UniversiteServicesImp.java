package com.first_entity.firstEntity.services;

import com.first_entity.firstEntity.entities.Department;
import com.first_entity.firstEntity.entities.Universite;
import com.first_entity.firstEntity.repositories.DepartmentRepository;
import com.first_entity.firstEntity.repositories.UniversiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversiteServicesImp implements UniversiteServices{
    private final UniversiteRepository universiteRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addOrUpdateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void removeUniversite(Integer idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        if(universite!=null) {
            universite.setDepartments(null);
        }
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public void assignUniversiteToDepartment(Integer idUniversite, Integer idDep) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Department department = departmentRepository.findById(idDep).orElse(null);
        if(universite.getDepartments()==null) {
            List<Department> departments = new ArrayList<>();
            departments.add(department);
            universite.setDepartments(departments);
        } else {
            universite.getDepartments().add(department);
        }
        universiteRepository.save(universite);
    }
}
