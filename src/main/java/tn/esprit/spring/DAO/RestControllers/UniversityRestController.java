package tn.esprit.spring.DAO.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.Entities.Reservation;
import tn.esprit.spring.DAO.Entities.Universite;
import tn.esprit.spring.DAO.Services.Reservation.IReservationService;
import tn.esprit.spring.DAO.Services.Universite.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("universite")
public class UniversityRestController {
    @Autowired
    IUniversiteService iUniversiteService;

    @GetMapping("/findAll")
    List<Universite> findAll(){
        return  iUniversiteService.findAll();
    }

    @PostMapping("/add")
    Universite addUniversite(@RequestBody Universite u) {
        return iUniversiteService.addUniversite(u);
    }

    @PutMapping("update/{id}")
    Universite updateUniversite(@PathVariable("id") Long id, @RequestBody Universite u){
        return iUniversiteService.editUniversite(id, u);
    }

    @DeleteMapping("/delete/{id}")
    void deleteUniversite(@PathVariable("id") Long id){
        iUniversiteService.deleteById(id);
    }

    @GetMapping("/{id}")
    Universite findById(@PathVariable("id") Long id){
        return iUniversiteService.findById(id);
    }

    @PutMapping("/{idFoyer}/{nomUniversite}")
    Universite affecterFoyerAUniversite(@PathVariable("idFoyer") long idFoyer,
                                        @PathVariable("nomUniversite") String nomUniversite){
        return  iUniversiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }

    @PutMapping("/{idUniversite}")
    Universite desaffecterFoyerAUniversite(@PathVariable("idUniversite") long idUniversite){
        return  iUniversiteService.desaffecterFoyerAUniversite(idUniversite);
    }
}
