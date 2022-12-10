package com.example.exam.controllers.Classe;

import com.example.exam.entities.Classe;
import com.example.exam.generic.ControllerGeneric;
import com.example.exam.services.Classe.ImpClasse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/classe")
public class ClasseController  {
    @Autowired
    ImpClasse service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Classe AjouterClasse(@RequestBody Classe c) throws Exception {
        try {
            return service.ajouterClasse(c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET)

    public List<Classe> FindallClasses() throws Exception{
        try {
            return (List<Classe>) service.FindAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
