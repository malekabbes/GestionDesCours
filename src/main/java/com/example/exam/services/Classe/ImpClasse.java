package com.example.exam.services.Classe;

import com.example.exam.Repositories.ClasseRepository;
import com.example.exam.entities.Classe;
import com.example.exam.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpClasse implements IntClasse{
    @Autowired
    ClasseRepository repo;
    @Override
    public Classe ajouterClasse(Classe c) throws Exception {
        return repo.save(c);
    }
    public Classe findClassebyCode(Integer code ) throws Exception {
        return repo.findClasseByCodeClasse(code);
    }
    public List<Classe> FindAll() throws Exception{
        return (List<Classe>) repo.findAll();
    }
}
