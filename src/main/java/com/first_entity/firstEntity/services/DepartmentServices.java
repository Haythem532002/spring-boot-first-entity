package com.first_entity.firstEntity.services;

import com.first_entity.firstEntity.entities.Department;

import java.util.List;

public interface DepartmentServices {
    List<Department> retrieveAllDepartments();
    Department addOrUpdateDepartment(Department department);
    Department retrieveDepartment(Integer idDepartement);
    void removeDepartment(Integer idDepartement);
}
