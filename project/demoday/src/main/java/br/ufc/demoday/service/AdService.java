package br.ufc.demoday.service;
import br.ufc.demoday.model.Ad;
import br.ufc.demoday.model.Immobile;
import br.ufc.demoday.model.User;
import br.ufc.demoday.repository.AdRepository;
import java.util.ArrayList;
import java.util.Optional;

import br.ufc.demoday.repository.ImmobileRepository;
import br.ufc.demoday.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdService {


    //Injeção automática de dependências spring na interface AdRepository
    @Autowired
    AdRepository adRepository;
    @Autowired
    ImmobileRepository immobileRepository;
    @Autowired
    UserRepository userRepository;

    //Tratativas vindas da camada controller,  Classe AdController

    public void save(int idAd, int idUser, int idImmobile, Ad entity){
        if (idAd != 0) {
            entity.setIdAd(idAd);
        }
        Optional<Immobile> immobile = immobileRepository.findById(idImmobile);
        Optional<User> user = userRepository.findById(idUser);
        if(immobile.isPresent()){
            entity.setImmobile(immobile.get());
        }
        if(user.isPresent()) {
            entity.setUser(user.get());
        }
        adRepository.save(entity);
    }

    public void update(int idAd, Ad entity){
        Optional<Ad> ad = adRepository.findById(idAd);
        if(ad.isPresent()){
            entity.setIdAd(ad.get().getIdAd());
            entity.setUser(ad.get().getUser());
            entity.setImmobile(ad.get().getImmobile());
            adRepository.save(entity);
        }
    }

    public Ad find(int idAd){
        if(idAd == 0){
            return null;
        }
        Optional<Ad> ad = adRepository.findById(idAd);
        if(ad.isPresent()){
            return ad.get();
        }
        return null;
    }

    public ArrayList<Ad> findAll(){
        return (ArrayList<Ad>) adRepository.findAll();
    }

    public void delete(int idAd){
        Optional<Ad> ad = adRepository.findById(idAd);
        if(ad.isPresent()){
            adRepository.delete(ad.get());
        }
    }
}
