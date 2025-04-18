package com.first_entity.firstEntity.services;


import com.first_entity.firstEntity.entities.Department;
import com.first_entity.firstEntity.entities.Etudiant;
import com.first_entity.firstEntity.repositories.DepartmentRepository;
import com.first_entity.firstEntity.repositories.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServicesImp implements DepartmentServices{
    private final DepartmentRepository departmentRepository;
    private final EtudiantRepository etudiantRepository;

    @Override
    public List<Department> retrieveAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department addOrUpdateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department retrieveDepartment(Integer idDepartement) {
        return departmentRepository.findById(idDepartement).orElse(null);
    }

    @Override
    public void removeDepartment(Integer idDepartement) {
        Department department = departmentRepository.findById(idDepartement).orElse(null);
        if(department!=null) {
            for(Etudiant etudiant:department.getEtudiants()) {
                etudiant.setDepartment(null);
            }
            etudiantRepository.saveAll(department.getEtudiants());
        }
//        department.setEtudiants(null);
        departmentRepository.deleteById(idDepartement);
    }
}
