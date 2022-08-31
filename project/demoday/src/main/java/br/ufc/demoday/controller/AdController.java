package br.ufc.demoday.controller;
import br.ufc.demoday.model.Ad;
import br.ufc.demoday.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping(path = "/api/ads")
//@PreAuthorize("isAuthenticated()")
public class AdController {

    @Autowired
    AdService adService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Ad>> findAll(){
        return new ResponseEntity<>(adService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{idAd}")
    public ResponseEntity<Ad> find(@PathVariable int idAd){
        return new ResponseEntity<>(adService.find(idAd), HttpStatus.OK);
    }
    @PostMapping("/{idAd}")
    public void save(@PathVariable int idAd, @RequestParam int idUser, @RequestParam int idImmobile, @RequestBody Ad ad){
        adService.save(idAd, idUser, idImmobile, ad);
    }

    @PutMapping("/{idAd}")
    public void update(@PathVariable int idAd, @RequestBody Ad ad){
        adService.update(idAd, ad);
    }

    @DeleteMapping("/{idAd}")
    public void delete(@PathVariable int idAd){
        adService.delete(idAd);
    }
}
