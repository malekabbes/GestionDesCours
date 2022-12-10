package com.example.exam.Repositories;

import com.example.exam.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<Classe, Integer> {
    Classe findClasseByCodeClasse(Integer code);
}