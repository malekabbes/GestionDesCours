package com.example.exam.services.Utilisateur;

import com.example.exam.Repositories.ClasseRepository;
import com.example.exam.Repositories.UtilisateurRepository;
import com.example.exam.entities.Classe;
import com.example.exam.entities.Niveau;
import com.example.exam.entities.Utilisateur;
import com.example.exam.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpUtilisateur implements IntUtilisateur {
    @Autowired
    UtilisateurRepository repo;
    @Autowired
    ClasseRepository crepo;
    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) throws Exception {
        try {
            return repo.save(utilisateur);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer codeClasse){
        Utilisateur user= repo.findById(idUtilisateur).orElse(null);
        Classe cl=crepo.findById(codeClasse).orElse(null);
        if (user!=null && cl!=null){
            user.setClasse(cl);
            repo.save(user);
        }
    }
    public Integer nbUtilisateursParNiveau(Niveau nv) throws Exception {
        return repo.countByClasse_Niveau(nv);
    }
}
