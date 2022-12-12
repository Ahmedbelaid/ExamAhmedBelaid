package com.example.ahmed_belaid.Controllers;


import com.example.ahmed_belaid.Repository.ParkingRepository;
import com.example.ahmed_belaid.Repository.PersonnelRepository;
import com.example.ahmed_belaid.Repository.ZoneRepository;
import com.example.ahmed_belaid.entities.Parking;
import com.example.ahmed_belaid.entities.Personnel;
import com.example.ahmed_belaid.entities.Poste;
import com.example.ahmed_belaid.entities.Zone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestController {


   @Autowired
   PersonnelRepository personnelRepository;



      @PostMapping("/addPersonnel")
    public Personnel ajouterPersonnel(@RequestBody Personnel personnel){
      return personnelRepository.save(personnel);
     }


     @Autowired
     ParkingRepository parkingRepository;
    @PostMapping("/addParkingToZones")
    public void ajoutParkingetZones (@RequestBody  Parking parking) {

     Parking parking1 = parkingRepository.findById(parking.getIdParking()).orElse(null);
        parking1.setIdParking();
     parkingRepository.save(parking1);
    }




    @Autowired
    ZoneRepository zoneRepository;

    @GetMapping ("/affecterPersonnelZone/{idZone}/{idPersonnel}")
    public void affecterPersonnelZone( @PathVariable int idZone, @PathVariable int idPersonnel){
        Zone zone = zoneRepository.findById(idZone).orElse(null);
        Personnel personnel = personnelRepository.findById(idPersonnel).orElse(null);
    personnel.setZone(zone);
    personnelRepository.save(personnel);


    }
    @GetMapping("/getNbGardesByZone/{idZone}")
    public void getNbrGardesByZone(@PathVariable Zone idZone ) {

        personnelRepository.findById(idZone.getIdZone());
    }



    @GetMapping("/nbGardeJour/{poste}")
    public Integer nombreGardeJour(@PathVariable Poste poste ) {

        return	personnelRepository.countByPoste(poste);
    }




    // @GetMapping("/getAllPersonnelByParking/{idParking}")
    // public List<Personnel> getAllPersonnelByParking(@PathVariable Parking parking) {
     //   return personnelRepository.findbyParking(parking);
   // }


    //@PostMapping("/affecterPersonnel")
     //void affecterPersonnelZone(@RequestBody int idZone, int idPersonnel) {
       //PersonnelRepository.save(personnel);
     //}

    //  @Autowired
    // RendezVousRepository rendezVousRepository;
    // @PostMapping ("/addRDVAndAssignMedAndPatient/{idMedecin}/{idPatient}")
    // public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv, @PathVariable Long idMedecin, @PathVariable Long idPatient)
    // {
        // Medecin medecin = medecinRepository.findById(idMedecin).orElse(null);
    //  Patient patient = patientRepository.findById(idPatient).orElse(null);
    //rdv.setMedecin(medecin);
    // rdv.setPatient(patient);
    // rendezVousRepository.save(rdv);
    //

    //  }
    }