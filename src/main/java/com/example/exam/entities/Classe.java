package com.example.exam.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeClasse;
    private String titre;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @OneToMany(mappedBy = "classe")
    private Set<CoursClassroom> coursclassroom;
}
