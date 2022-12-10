package com.example.exam.controllers.Classe;

import com.example.exam.entities.Classe;
import com.example.exam.entities.Niveau;
import com.example.exam.entities.Specialite;
import com.example.exam.entities.Utilisateur;
import com.example.exam.generic.ControllerGeneric;
import com.example.exam.services.Utilisateur.ImpUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UtilisateurController  {
@Autowired
ImpUtilisateur service;
@RequestMapping(value = "/add",method = RequestMethod.POST)
public Utilisateur AjouterUtilisateur(@RequestBody Utilisateur user) throws Exception{
  return service.ajouterUtilisateur(user);
}
@RequestMapping(value="/{idu}/{idc}",method = RequestMethod.PUT)
  public void affecterUtilisateurClasse(@PathVariable Integer idu,@PathVariable Integer idc){
  service.affecterUtilisateurClasse(idu,idc);
}
@RequestMapping(value = "/nb/{niv}",method = RequestMethod.GET)
  public Integer nbUtilisateurParNiveau(@PathVariable Niveau niv) throws Exception {
  return service.nbUtilisateursParNiveau(niv);
}


}
