package com.example.exam.controllers.CoursClassroom;

import com.example.exam.Repositories.CoursClassroomRepository;
import com.example.exam.entities.CoursClassroom;
import com.example.exam.entities.Niveau;
import com.example.exam.entities.Specialite;
import com.example.exam.services.CoursClassroom.ImpClassroom;
import com.example.exam.services.CoursClassroom.IntClassroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/coursclassroom")
public class CoursClassroomController {
@Autowired
    ImpClassroom service;

@RequestMapping(value = "/add/{code}",method = RequestMethod.POST)
public CoursClassroom AjouterClassroom(@RequestBody CoursClassroom cc, @PathVariable Integer code) throws Exception {
    return service.ajouterCoursClassroom(cc,code);
}
    @RequestMapping(value = "/desaffecterCoursClassroom/{idc}",method = RequestMethod.PUT)
    public void desaffecterCoursClassroomClasse(@PathVariable Integer idc) {
       service.desaffecterCoursClassroomClasse(idc);
    }
    @Scheduled(fixedRate = 60000)
    public void archiverCoursClassrooms(){
        service.Archiveclassrooms();
    }

    @RequestMapping(value = "/nbrheures/{sp}/{nv}",method = RequestMethod.GET)
    public Integer nbHeuresParSpecEtNiv(@PathVariable Specialite sp, @PathVariable Niveau nv) {
        return service.nbHeuresParSpecEtNiv(sp,nv);
    }
}
