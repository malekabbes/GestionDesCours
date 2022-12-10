package com.example.exam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CoursClassroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCours;
    @Enumerated(EnumType.STRING)
  private Specialite specialite;
    private String nom;
    private int nbHeures;
    private Boolean archive;
    @ManyToOne
    @JsonIgnore

    private Classe classe;

}
