package com.example.exam.Repositories;

import com.example.exam.entities.Niveau;
import com.example.exam.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
Integer countByClasse_Niveau(Niveau nv) throws Exception;
}