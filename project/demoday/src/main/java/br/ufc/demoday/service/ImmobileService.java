package br.ufc.demoday.service;
import br.ufc.demoday.model.Immobile;
import br.ufc.demoday.repository.ImmobileRepository;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImmobileService {

    @Autowired
    ImmobileRepository immobileRepository;
    public void save(int idImmobile, Immobile entity){
        if (idImmobile != 0) {
            entity.setIdImmobile(idImmobile);
        }
        immobileRepository.save(entity);
    }


    public void update(int idImmobile, Immobile entity){
        Optional<Immobile> immobile = immobileRepository.findById(idImmobile);
        if(immobile.isPresent()){
            entity.setIdImmobile(immobile.get().getIdImmobile());
            immobileRepository.save(entity);
        }
    }

    public Immobile find(int idImmobile){
        if(idImmobile == 0){
            return null;
        }
        Optional<Immobile> immobile = immobileRepository.findById(idImmobile);
        if(immobile.isPresent()){
            return immobile.get();
        }
        return null;
    }

    public ArrayList<Immobile> findAll(){
        return (ArrayList<Immobile>) immobileRepository.findAll();
    }

    public void delete(int idImmobile){
        Optional<Immobile> immobile = immobileRepository.findById(idImmobile); // ok
        if(immobile.isPresent()){
            immobileRepository.delete(immobile.get());
        }
    }

}
