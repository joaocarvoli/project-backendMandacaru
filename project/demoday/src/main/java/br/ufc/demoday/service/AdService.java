package br.ufc.demoday.service;
import br.ufc.demoday.model.Ad;
import br.ufc.demoday.model.Immobile;
import br.ufc.demoday.model.ProcessApi;
import br.ufc.demoday.model.User;
import br.ufc.demoday.repository.AdRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import br.ufc.demoday.repository.ImmobileRepository;
import br.ufc.demoday.repository.UserRepository;
import br.ufc.demoday.service.api.CheckProcessStatus;
import br.ufc.demoday.service.api.CreateProcess;
import br.ufc.demoday.service.api.DocumentProcess;
import br.ufc.demoday.service.api.DocumentUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class AdService {


    //Injeção automática de dependências spring na interface AdRepository
    @Autowired
    AdRepository adRepository;
    @Autowired
    ImmobileRepository immobileRepository;
    @Autowired
    UserRepository userRepository;

    private DocumentProcess documentProcess;
    private final HashMap<Integer, DocumentProcess> cacheDocumentProcess = new HashMap<>();
    private final HashMap<Integer, CreateProcess> cacheProcess = new HashMap<>();

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

    public Ad find(int idAd, boolean pending){
        Optional<Ad> ad;
        if(idAd == 0){
            return null;
        }
        if(pending){
            ad = adRepository.findById(idAd);
        } else {
            ad = Optional.ofNullable(adRepository.findNotPendingById(idAd));
        }

        if(ad.isPresent()){
            return ad.get();
        }
        return null;
    }

    public ArrayList<Ad> findAll(boolean pending){
        if(pending){
            return (ArrayList<Ad>) adRepository.findAll();
        }
        return adRepository.findNotPending();
    }

    public void delete(int idAd){
        Optional<Ad> ad = adRepository.findById(idAd);
        ad.ifPresent(value -> adRepository.delete(value));
    }

    public void createProcess(int idAd, ProcessApi users) throws IOException {
        if(cacheDocumentProcess.get(idAd) == null){
            CreateProcess process = new CreateProcess(users.getUsers());
            process.createProcess();
            documentProcess = new DocumentProcess(process);
            documentProcess.createProcessDocument("file");
            cacheDocumentProcess.put(idAd, documentProcess);
            cacheProcess.put(idAd, process);
        } else {
            documentProcess = cacheDocumentProcess.get(idAd);
        }
    }
    public void uploadDocument(int idAd, MultipartFile file) throws InterruptedException, IOException {
        if(cacheDocumentProcess.get(idAd) != null){
            DocumentUpload documentUpload = new DocumentUpload(cacheDocumentProcess.get(idAd));
            documentUpload.sendDocument(file);
            boolean uploadStatus = documentUpload.checkStatus();
            if (uploadStatus){
                documentUpload.processRun();
            }
        }
        Thread thread = checkProcessStatus(idAd);
        thread.start();
    }

    private Thread checkProcessStatus(int idAd){
        Runnable runnable = () -> {
            CreateProcess process = cacheProcess.get(idAd);
            CheckProcessStatus checkProcessStatus = new CheckProcessStatus(process);
            while(true){
                try {
                    Thread.sleep(600000);
                    if(checkProcessStatus.doCheck()){
                        Optional<Ad> ad = adRepository.findById(idAd);
                        if(ad.isPresent()){
                            ad.get().setAdStatus("done");
                            adRepository.save(ad.get());
                        }
                        break;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        return new Thread(runnable);
    }
}
