package com.first_entity.firstEntity.repositories;

import com.first_entity.firstEntity.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    //Solution 1
    Etudiant findByNomEAndPrenomE(String nom,String prenom);
    //Solution 2
    @Query("select e from Etudiant e where e.nomE = :nom and e.prenomE = :prenom")
    Etudiant getEtudiantByNomAndPrenom(@Param("nom")String nomE,@Param("prenom")String prenomE);


    //Solution1
    List<Etudiant> getEtudiantByDepartment_IdDepart(Integer idDepart);
    //Solution 2
    @Query("select e from Etudiant e where e.department = :idDep")
    List<Etudiant> getEtudiantByDepartment(@Param("idDep") Integer idDepart);
}