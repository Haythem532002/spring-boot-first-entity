package com.first_entity.firstEntity.controllers;


import com.first_entity.firstEntity.entities.Department;
import com.first_entity.firstEntity.services.DepartmentServicesImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentRestController {
    private final DepartmentServicesImp departmentServicesImp;

    @PostMapping("/add")
    Department addDepartment(
            @RequestBody Department department
    ) {
        return departmentServicesImp.addOrUpdateDepartment(department);
    }
    @PutMapping("/update")
    Department updateDepartment(@RequestBody Department department) {
        return departmentServicesImp.addOrUpdateDepartment(department);
    }
    @GetMapping("/get/{id}")
    Department getDepartment(
            @PathVariable("id") Integer idDepartment
    ) {
        return departmentServicesImp.retrieveDepartment(idDepartment);
    }
    @GetMapping("/all")
    List<Department> getAllDepartment() {
        return departmentServicesImp.retrieveAllDepartments();
    }
    @DeleteMapping("/delete/{id}")
    void deleteDepartment(
            @PathVariable("id") Integer idDepartment
    ) {
        departmentServicesImp.removeDepartment(idDepartment);
    }
}
