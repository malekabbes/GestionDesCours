package com.example.exam.services.CoursClassroom;

import com.example.exam.Repositories.CoursClassroomRepository;
import com.example.exam.entities.Classe;
import com.example.exam.entities.CoursClassroom;
import com.example.exam.entities.Niveau;
import com.example.exam.entities.Specialite;
import com.example.exam.generic.ImplementationGeneric;
import com.example.exam.services.Classe.ImpClasse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpClassroom implements IntClassroom {
    @Autowired
    CoursClassroomRepository repo;
    @Autowired
    ImpClasse serviceClasse;
    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse) throws Exception {
        Classe cl=serviceClasse.findClassebyCode(codeClasse);
        cc.setClasse(cl);
        return repo.save(cc);
    }
    @Override
    public void desaffecterCoursClassroomClasse(Integer idCours){
             CoursClassroom coursclasse=repo.findById(idCours).orElse(null);
        coursclasse.setClasse(null);
        repo.save(coursclasse);

    }
    public void Archiveclassrooms(){
        repo.ArchiveAllclassroom();
    }

    //@Override
    //public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv) {
      //  Integer nbrHeures = 0;
       // nbrHeures = repo.findAll()
        //        .stream()
         //       .filter(c -> c.getSpecialite().equals(sp) && c.getClasse().getNiveau().equals(nv))
          //      .mapToInt(CoursClassroom::getNbHeures)
           //     .sum();
        //return nbrHeures;
    //}
    ///////////////////////     EN JPQL     //////////////////////
    @Override
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv){
       return repo.nbHeuresParSpecEtNiv(sp,nv);
    }
}
