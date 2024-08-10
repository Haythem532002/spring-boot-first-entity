package com.first_entity.firstEntity.repositories;

import com.first_entity.firstEntity.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}