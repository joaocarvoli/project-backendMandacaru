package br.ufc.demoday.controller;
import br.ufc.demoday.model.Ad;
import br.ufc.demoday.model.ProcessApi;
import br.ufc.demoday.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;


@RestController
@RequestMapping(path = "/api/ads")
@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class AdController {

    @Autowired
    AdService adService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Ad>> findAll(@RequestParam boolean pending){
        return new ResponseEntity<>(adService.findAll(pending), HttpStatus.OK);
    }
    @GetMapping("/{idAd}")
    public ResponseEntity<Ad> find(@PathVariable int idAd, @RequestParam boolean pending){
        return new ResponseEntity<>(adService.find(idAd, pending), HttpStatus.OK);
    }
    @PostMapping("/{idAd}")
    public void save(@PathVariable int idAd, @RequestParam int idUser, @RequestParam int idImmobile, @RequestBody Ad ad){
        adService.save(idAd, idUser, idImmobile, ad);
    }

    @PostMapping("/{idAd}/create_process")
    public void createProcess(@PathVariable int idAd, @RequestBody ProcessApi users) throws IOException {
        adService.createProcess(idAd, users);
    }

    @RequestMapping(value = "/{idAd}/create_process/upload_document", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createProcess(@PathVariable int idAd, @RequestParam("file") MultipartFile file) throws InterruptedException, IOException {
        adService.uploadDocument(idAd, file);
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
