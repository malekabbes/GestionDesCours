package com.example.exam.Repositories;

import com.example.exam.entities.CoursClassroom;
import com.example.exam.entities.Niveau;
import com.example.exam.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CoursClassroomRepository extends JpaRepository<CoursClassroom, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update CoursClassroom c set c.archive=true")
    public void ArchiveAllclassroom();
    @Transactional
     @Query(value = "SELECT SUM(c.nbHeures) as heures FROM CoursClassroom c WHERE c.specialite=?1 AND c.classe.niveau=?2")
     public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv);
}