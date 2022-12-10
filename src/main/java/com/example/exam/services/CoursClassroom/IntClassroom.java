package com.example.exam.services.CoursClassroom;

import com.example.exam.entities.Classe;
import com.example.exam.entities.CoursClassroom;
import com.example.exam.entities.Niveau;
import com.example.exam.entities.Specialite;
import com.example.exam.generic.Igeneric;

public interface IntClassroom {
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse) throws Exception;

    public void desaffecterCoursClassroomClasse(Integer idCours) throws Exception;

    Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv) throws  Exception;
}