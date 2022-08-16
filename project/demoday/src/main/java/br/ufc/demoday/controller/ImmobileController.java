package br.ufc.demoday.controller;
import br.ufc.demoday.model.Immobile;
import br.ufc.demoday.service.ImmobileService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/immobile")
public class ImmobileController {


    @Autowired
    ImmobileService immobileService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Immobile>> findAll(){

        return new ResponseEntity<ArrayList<Immobile>>(immobileService.findAll(), HttpStatus.OK);

    }
    @GetMapping("/{immobileId}")
    public ResponseEntity<Immobile> find(@PathVariable int userId){

        return new ResponseEntity<Immobile>(immobileService.find(userId), HttpStatus.OK);
    }
    @PostMapping("/{immobileId}")
    public void save(@PathVariable int immobileId, @RequestBody Immobile immobile){
        immobileService.save(immobileId, immobile);
    }

    @PutMapping("/{immobileId}")
    public void update(@PathVariable int immobileId, @RequestBody Immobile immobile){
        immobileService.update(immobileId, immobile);
    }

    @DeleteMapping("/{immobileId}")
    public void delete(@PathVariable int immobileId){
        immobileService.delete(immobileId);
    }


}



