package br.ufc.demoday.controller;
import br.ufc.demoday.model.Ad;
import br.ufc.demoday.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping(path = "/api/ads")
public class AdController {
    @Autowired
    AdService adService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Ad>> findAll(){
        return new ResponseEntity<ArrayList<Ad>>(adService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{adId}")
    public ResponseEntity<Ad> find(@PathVariable int adId){
        return new ResponseEntity<Ad>(adService.find(adId), HttpStatus.OK);
    }
    @PostMapping("/{adId}")
    public void save(@PathVariable int adId, @RequestBody Ad ad){
        adService.save(adId, ad);
    }

    @PutMapping("/{adId}")
    public void update(@PathVariable int adId, @RequestBody Ad ad){
        adService.update(adId, ad);
    }

    @DeleteMapping("/{adId}")
    public void delete(@PathVariable int adId){
        adService.delete(adId);
    }



}
