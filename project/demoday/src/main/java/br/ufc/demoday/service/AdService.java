package br.ufc.demoday.service;
import br.ufc.demoday.model.Ad;
import br.ufc.demoday.model.Immobile;
import br.ufc.demoday.model.User;
import br.ufc.demoday.repository.AdRepository;
import br.ufc.demoday.repository.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdService {


    //Injeção automática de dependências spring na interface AdRepository
    @Autowired
    AdRepository AdRepository;

    //Tratativas vindas da camada controller,  Classe AdController

    public void save(int idAd, Ad entity){

        Ad ad =  new Ad();

        if (idAd != 0) {

            entity.setIdAd(idAd);
            ad.setImmobile(entity.getImmobile());;
            ad.setAdStatus(entity.isAdStatus());
            ad.setPrice(entity.getPrice());
            ad.setUser(entity.getUser());
            AdRepository.save(entity);
        }


    }

    public void update(int idAd, Ad entity){


        // Falta finalizar esse método pois é preciso que a classe User esteja pronta
        Ad ad = new Ad();

        if (idAd != 0) {

            //	entity.getIdAd();
            ad.setImmobile(entity.getImmobile());;
            ad.setAdStatus(entity.isAdStatus());
            ad.setPrice(entity.getPrice());
            ad.setUser(entity.getUser());
            AdRepository.save(entity);
        }

    }

    public Ad find(int idAd){
        if(idAd == 0){
            return null;
        }
        Optional<Ad> ad = AdRepository.findById(idAd);
        if(ad.isPresent()){
            return ad.get();
        }
        return null;
    }

    public ArrayList<Ad> findAll(){
        return (ArrayList<Ad>) AdRepository.findAll();
    }

    public void delete(int idAd){
        Ad ad = find(idAd);
        if(idAd!= 0){
            AdRepository.delete(ad);
        }
    }



}
