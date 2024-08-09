package com.first_entity.firstEntity.services;

import com.first_entity.firstEntity.entities.Departement;

import java.util.List;

public interface DepartmentServices {
    List<Departement> retrieveAllDepartments();
    Departement addOrUpdateDepartment(Departement departement);
    Departement retrieveDepartment(Integer idDepartement);
    void removeDepartment(Integer idDepartement);
}
