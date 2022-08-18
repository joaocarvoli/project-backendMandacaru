package br.ufc.demoday.service;
import br.ufc.demoday.repository.UserRepository;
import br.ufc.demoday.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

//Anotação @Sevice para referenciar camada de Negócio
@Service
public class UserService {

    //Injeção automática de dependências spring na interface UserRepository
    @Autowired
    UserRepository userRepository;

    //Tratativas vindas da camada controller,  Classe UserController

    public void save(int idUser, User entity){
        if (idUser != 0) {
            entity.setIdUSer(idUser);
        }
        userRepository.save(entity);
    }

    public void update(int idUser, User entity){
        Optional<User> user = userRepository.findById(idUser);
        if(user.isPresent()){
            entity.setIdUSer(user.get().getIdUSer());
            userRepository.save(entity);
        }

    }

    public User find(int idUser){
        if(idUser == 0){
            return null;
        }
        Optional<User> user = userRepository.findById(idUser);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public ArrayList<User> findAll(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public void delete(int idUser){
        Optional<User> user = userRepository.findById(idUser);
        if(user.isPresent()){
            userRepository.delete(user.get());
        }
    }
}
